package com.example.bookstore.test;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Cart;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.CheckoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutServiceTest {

    private BookService bookService;
    private CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
        bookService.init(); // ensure tables and seed data
        checkoutService = new CheckoutService();
    }

    @Test
    void checkoutCreatesOrder() {
        // pick an existing seeded book (Clean Code)
        var books = bookService.searchByTitle("Clean Code");
        assertFalse(books.isEmpty());
        Book b = books.get(0);

        Cart cart = new Cart();
        cart.addBook(b, 1);

        long orderId = checkoutService.checkout(null, cart); // userId null
        assertTrue(orderId > 0, "Expected order id > 0");
    }
}
