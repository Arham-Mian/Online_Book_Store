package com.example.bookstore.test;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.dao.OrderDao;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Cart;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.CheckoutService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CheckoutServiceTest {

    private static final BookService bookService = new BookService();
    private static final CheckoutService checkoutService = new CheckoutService();
    private static final BookDao bookDao = new BookDao();
    private static Long tempBookId;

    @BeforeAll
    static void setupSchema() {
        // make sure tables exist
        bookService.init();      // creates books + seeds if empty
        checkoutService.init();  // creates orders + order_items
    }

    @BeforeEach
    void insertTempBook() {
        // create a unique book with plenty of stock
        Book b = new Book();
        b.setTitle("JUnit Temp Book " + System.nanoTime());
        b.setAuthor("Test Author");
        b.setIsbn("TEST-" + System.nanoTime()%1000000000L);
        b.setPrice(new BigDecimal("123.45"));
        b.setStock(50);
        tempBookId = bookDao.insert(b);
        assertTrue(tempBookId != null && tempBookId > 0, "temp book should be inserted");
    }

    @AfterEach
    void cleanupTempBook() {
        // remove just the temp book we created (orders/order_items keep FK history)
        // If you want, you can also delete order_items/order rows created by this test.
        try {
            // safest: set stock low instead of hard delete to avoid FK issues
            // or hard delete if no orders were created
            // Here we try hard delete; if FK blocks, we ignore.
            var con = com.example.bookstore.config.DB.getConnection();
            try (var ps = con.prepareStatement("DELETE FROM books WHERE id = ?")) {
                ps.setLong(1, tempBookId);
                ps.executeUpdate();
            }
            con.close();
        } catch (Exception ignored) { }
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void checkoutCreatesOrder() {
        // Build a cart with our known book (qty 2 < stock 50)
        var cart = new Cart();
        Book temp = bookDao.findById(tempBookId);
        assertNotNull(temp, "Inserted temp book must exist");
        cart.addBook(temp, 2);

        long orderId = checkoutService.checkout(null, cart);
        assertTrue(orderId > 0, "order should be created");
    }
}
