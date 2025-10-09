package com.example.bookstore.dao;

import com.example.bookstore.config.DB;
import com.example.bookstore.model.Book;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all direct DB operations for 'books' table.
 * Includes schema creation, seeding, searching, and inserting.
 */
public class BookDao {

    /** ✅ Step 1: Create table (if missing) */
    public void createTableIfNotExists() {
        String sql = """
            CREATE TABLE IF NOT EXISTS books (
                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                title  VARCHAR(255) NOT NULL,
                author VARCHAR(255) NOT NULL,
                isbn   VARCHAR(32),
                price  DECIMAL(10,2) NOT NULL,
                stock  INT DEFAULT 0,
                UNIQUE KEY uq_title_author (title, author)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
        """;
        try (Connection con = DB.getConnection();
             Statement st = con.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Failed creating 'books' table", e);
        }
    }

    /** ✅ Step 2: Seed initial data only when table empty */
    public void seedIfEmpty() {
        String check = "SELECT COUNT(*) FROM books";
        try (Connection con = DB.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(check)) {

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("✅ Books already exist — skipping seed.");
                return;
            }

        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Failed checking seed state", e);
        }

        System.out.println("🌱 Seeding initial books...");
        seedDefaults();
    }

    /** ✅ Step 3: Seed default books safely (no duplicates) */
    private void seedDefaults() {
        String insert = """
            INSERT INTO books(title, author, isbn, price, stock)
            VALUES (?, ?, ?, ?, ?)
            ON DUPLICATE KEY UPDATE
              price = VALUES(price),
              stock = VALUES(stock)
        """;

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(insert)) {

            addSample(ps, "Clean Code", "Robert C. Martin", "9780132350884", new BigDecimal("450.00"), 10);
            addSample(ps, "Design Patterns", "Erich Gamma", "9780201633610", new BigDecimal("550.00"), 8);
            addSample(ps, "Effective Java", "Joshua Bloch", "9780134685991", new BigDecimal("600.00"), 5);
            addSample(ps, "The Pragmatic Programmer", "Andrew Hunt", "9780201616224", new BigDecimal("550.00"), 7);
            addSample(ps, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780747532699", new BigDecimal("400.00"), 6);

        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Failed seeding default books", e);
        }
    }

    /** Helper to add each book safely */
    private void addSample(PreparedStatement ps, String title, String author, String isbn, BigDecimal price, int stock)
            throws SQLException {
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setString(3, isbn);
        ps.setBigDecimal(4, price);
        ps.setInt(5, stock);
        ps.executeUpdate();
    }

    /** ✅ Step 4: Find book by ID */
    public Book findById(long id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapBook(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("⚠️ findById failed", e);
        }
        return null;
    }

    /** ✅ Step 5: Check stock */
    public boolean hasSufficientStock(long bookId, int qty) {
        String sql = "SELECT stock FROM books WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, bookId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt("stock") >= qty;
            }
        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Stock check failed", e);
        }
    }

    /** ✅ Step 6: Search by title */
    public List<Book> searchByTitle(String query) {
        String sql = "SELECT * FROM books WHERE title LIKE ?";
        return runSearch(sql, "%" + query + "%");
    }

    /** ✅ Step 7: Search by author */
    public List<Book> searchByAuthor(String query) {
        String sql = "SELECT * FROM books WHERE author LIKE ?";
        return runSearch(sql, "%" + query + "%");
    }

    /** ✅ Step 8: Common search logic */
    private List<Book> runSearch(String sql, String param) {
        List<Book> list = new ArrayList<>();
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, param);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapBook(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Search failed", e);
        }
        return list;
    }

    /** ✅ Step 9: Map ResultSet → Book object */
    private Book mapBook(ResultSet rs) throws SQLException {
        Book b = new Book();
        b.setId(rs.getLong("id"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setIsbn(rs.getString("isbn"));
        b.setPrice(rs.getBigDecimal("price"));
        b.setStock(rs.getInt("stock"));
        return b;
    }

    /** ✅ Step 10: Manual insert (optional) */
    public long insert(Book b) {
        String sql = """
            INSERT INTO books(title, author, isbn, price, stock)
            VALUES (?, ?, ?, ?, ?)
            ON DUPLICATE KEY UPDATE
              price = VALUES(price),
              stock = VALUES(stock)
        """;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getIsbn());
            ps.setBigDecimal(4, b.getPrice());
            ps.setInt(5, b.getStock());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) return keys.getLong(1);
            }
            return -1;

        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Insert failed", e);
        }
    }
}
