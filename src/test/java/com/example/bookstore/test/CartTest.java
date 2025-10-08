package com.example.bookstore.test;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    private Cart cart;
    private Book sample;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        sample = new Book();
        sample.setId(1L);
        sample.setTitle("Sample");
        sample.setAuthor("Author");
        sample.setPrice(new BigDecimal("100.00"));
        sample.setStock(5);
    }

    @Test
    void addAndCalculateTotal() {
        cart.addBook(sample, 2);
        Map<Book, Integer> items = cart.getItems();
        assertFalse(items.isEmpty());
        assertEquals(1, items.size());
        assertEquals(2, items.get(sample).intValue());

        // calculateTotal returns BigDecimal or String? Use whichever your Cart implements.
        // Assuming calculateTotal returns java.math.BigDecimal
        assertNotNull(cart.calculateTotal());
        assertEquals(new BigDecimal("200.00"), cart.calculateTotal());
    }

    @Test
    void removeBook() {
        cart.addBook(sample, 2);
        cart.removeBook(sample);
        assertTrue(cart.isEmpty());
    }
}
