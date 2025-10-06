package com.example.bookstore.dao;

import com.example.bookstore.config.DB;
import com.example.bookstore.model.Book;

import java.math.BigDecimal;
import java.sql.*;
import java.time.Instant;
import java.util.Map;

public class OrderDao {

    public void createTablesIfNotExists() {
        String orders = """
            CREATE TABLE IF NOT EXISTS orders(
              id BIGINT PRIMARY KEY AUTO_INCREMENT,
              user_id BIGINT NULL,
              total DECIMAL(10,2) NOT NULL,
              created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
            """;
        String items = """
            CREATE TABLE IF NOT EXISTS order_items(
              id BIGINT PRIMARY KEY AUTO_INCREMENT,
              order_id BIGINT NOT NULL,
              book_id BIGINT NOT NULL,
              quantity INT NOT NULL,
              price DECIMAL(10,2) NOT NULL,
              FOREIGN KEY (order_id) REFERENCES orders(id),
              FOREIGN KEY (book_id) REFERENCES books(id)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
            """;
        try (Connection con = DB.getConnection(); Statement st = con.createStatement()) {
            st.execute(orders);
            st.execute(items);
        } catch (SQLException e) {
            throw new RuntimeException("Failed creating orders tables", e);
        }
    }

    /** Places an order + items, and (optionally) reduces stock inside the same transaction */
    public long createOrder(Long userId, BigDecimal total, Map<Book, Integer> cartItems) {
        String insertOrder = "INSERT INTO orders(user_id,total,created_at) VALUES(?,?,?)";
        String insertItem  = "INSERT INTO order_items(order_id,book_id,quantity,price) VALUES(?,?,?,?)";
        String reduceStock = "UPDATE books SET stock = stock - ? WHERE id = ? AND stock >= ?";

        try (Connection con = DB.getConnection()) {
            con.setAutoCommit(false);
            long orderId;

            // 1) Insert order
            try (PreparedStatement ps = con.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, userId, Types.BIGINT); // nullable
                ps.setBigDecimal(2, total);
                ps.setTimestamp(3, Timestamp.from(Instant.now()));
                ps.executeUpdate();
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (!keys.next()) throw new SQLException("No order id returned");
                    orderId = keys.getLong(1);
                }
            }

            // 2) Insert items + reduce stock
            try (PreparedStatement psItem = con.prepareStatement(insertItem);
                 PreparedStatement psStock = con.prepareStatement(reduceStock)) {
                for (Map.Entry<Book, Integer> e : cartItems.entrySet()) {
                    Book b = e.getKey();
                    int qty = e.getValue();

                    // item
                    psItem.setLong(1, orderId);
                    psItem.setLong(2, b.getId());
                    psItem.setInt(3, qty);
                    psItem.setBigDecimal(4, b.getPrice());
                    psItem.addBatch();

                    // stock reduce
                    psStock.setInt(1, qty);
                    psStock.setLong(2, b.getId());
                    psStock.setInt(3, qty);
                    psStock.addBatch();
                }
                psItem.executeBatch();

                int[] stockRes = psStock.executeBatch();
                // ensure no negative stock
                for (int r : stockRes) {
                    if (r == 0) {
                        con.rollback();
                        throw new RuntimeException("Insufficient stock for one or more items");
                    }
                }
            }

            con.commit();
            return orderId;
        } catch (SQLException e) {
            throw new RuntimeException("Order placement failed", e);
        }
    }
}
