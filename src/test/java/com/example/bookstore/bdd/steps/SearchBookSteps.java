package com.example.bookstore.bdd.steps;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchBookSteps {

    private final BookDao bookDao = new BookDao();
    private final BookService bookService = new BookService();

    private List<Book> searchResults;

    @Given("the bookstore has {string} by {string} priced {double} with stock {int}")
    public void the_bookstore_has_book(String title, String author, Double price, Integer stock) {
        // Ensure table + defaults exist (idempotent)
        bookDao.createTableIfNotExists();

        // Insert or update by ISBN (simple heuristic: title-based pseudo ISBN here for testing)
        // In real, pass an explicit ISBN from feature. For now generate a stable test ISBN:
        String testIsbn = ("TEST-" + title).replaceAll("\\s+", "-").toUpperCase();

        // Try insert; if unique constraint on isbn hits, ignore or update price/stock
        try {
            Book b = new Book();
            b.setTitle(title);
            b.setAuthor(author);
            b.setIsbn(testIsbn);
            b.setPrice(new BigDecimal(String.format("%.2f", price)));
            b.setStock(stock);
            bookDao.insert(b); // will fail if ISBN exists with UNIQUE; optional: catch and ignore
        } catch (RuntimeException ex) {
            // optional upsert behavior: ignore duplicates in tests
        }

        // Also seed defaults to ensure catalog presence (idempotent)
        bookService.init();
    }

    @When("the user searches for title {string}")
    public void the_user_searches_for_title(String q) {
        searchResults = bookService.searchByTitle(q);
    }

    @Then("the system shows a result with title {string} and author {string}")
    public void the_system_shows_a_result_with_title_and_author(String expectedTitle, String expectedAuthor) {
        assertNotNull(searchResults, "Search results should not be null");
        assertFalse(searchResults.isEmpty(), "No books found in search results");

        boolean match = searchResults.stream()
                .anyMatch(b -> expectedTitle.equalsIgnoreCase(b.getTitle())
                        && expectedAuthor.equalsIgnoreCase(b.getAuthor()));

        assertTrue(match, "Expected book not found: " + expectedTitle + " by " + expectedAuthor);
    }
}
