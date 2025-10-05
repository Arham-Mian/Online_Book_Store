package com.example.bookstore.dao;

import com.example.bookstore.config.DB;
import com.example.bookstore.model.Book;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    /** ✅ Step 1: Create table (if missing) */
    public void createTableIfNotExists() {
        String sql = """
            CREATE TABLE IF NOT EXISTS books(
              id BIGINT PRIMARY KEY AUTO_INCREMENT,
              title  VARCHAR(255) NOT NULL,
              author VARCHAR(255) NOT NULL,
              isbn   VARCHAR(20),
              price  DECIMAL(10,2) NOT NULL,
              stock  INT DEFAULT 0,
              KEY idx_title (title),
              KEY idx_author (author),
              UNIQUE KEY uk_isbn (isbn)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
            """;
        try (Connection con = DB.getConnection();
             Statement st = con.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Failed creating books table", e);
        }
    }

    /** ✅ Step 2: Seed initial data (always runs, but ignores duplicates) */
    public void seedDefaults() {
        final String insert = """
            INSERT IGNORE INTO books(title, author, isbn, price, stock)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(insert)) {

            // Add Sample Books
            addSample(ps, "Clean Code", "Robert C. Martin", "9780132350884", new BigDecimal("450.00"), 10);
            addSample(ps, "Design Patterns", "Erich Gamma", "9780201633610", new BigDecimal("550.00"), 8);
            addSample(ps, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9780747532699", new BigDecimal("400.00"), 7);

        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Failed seeding default books", e);
        }
    }

    /** Helper to insert a single book safely */
    private void addSample(PreparedStatement ps, String title, String author, String isbn, BigDecimal price, int stock)
            throws SQLException {
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setString(3, isbn);
        ps.setBigDecimal(4, price);
        ps.setInt(5, stock);
        ps.executeUpdate(); // INSERT IGNORE avoids duplicates
    }

    /** ✅ Step 3: Search books by title */
    public List<Book> searchByTitle(String query) {
        String sql = "SELECT id,title,author,isbn,price,stock FROM books WHERE title LIKE ?";
        return runSearch(sql, "%" + query + "%");
    }

    /** ✅ Step 4: Search books by author */
    public List<Book> searchByAuthor(String query) {
        String sql = "SELECT id,title,author,isbn,price,stock FROM books WHERE author LIKE ?";
        return runSearch(sql, "%" + query + "%");
    }

    /** Reusable search logic */
    private List<Book> runSearch(String sql, String param) {
        List<Book> list = new ArrayList<>();
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, param);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book b = new Book();
                    b.setId(rs.getLong("id"));
                    b.setTitle(rs.getString("title"));
                    b.setAuthor(rs.getString("author"));
                    b.setIsbn(rs.getString("isbn"));
                    b.setPrice(rs.getBigDecimal("price"));
                    b.setStock(rs.getInt("stock"));
                    list.add(b);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("⚠️ Search failed", e);
        }
        return list;
    }

    /** ✅ Optional: manual insert method */
    public long insert(Book b) {
        String sql = "INSERT INTO books(title,author,isbn,price,stock) VALUES(?,?,?,?,?)";
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
