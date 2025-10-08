package com.example.bookstore.test;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
        // ensure DB table exists and seed defaults
        bookService.init();
    }

    @Test
    void searchByTitle_shouldReturnCleanCode() {
        List<Book> results = bookService.searchByTitle("Clean Code");
        assertNotNull(results);
        assertFalse(results.isEmpty(), "Expected at least one match for 'Clean Code'");
        boolean found = results.stream().anyMatch(b -> "Clean Code".equals(b.getTitle()));
        assertTrue(found, "Clean Code should be present in search results");
    }

    @Test
    void searchByAuthor_shouldReturnDesignPatternsAuthor() {
        List<Book> results = bookService.searchByAuthor("Erich Gamma");
        assertNotNull(results);
        assertFalse(results.isEmpty());
        boolean found = results.stream().anyMatch(b -> "Erich Gamma".equals(b.getAuthor()));
        assertTrue(found);
    }
}
