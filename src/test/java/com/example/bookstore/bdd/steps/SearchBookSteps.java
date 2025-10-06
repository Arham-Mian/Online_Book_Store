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

    private final BookService bookService = new BookService();
    private final BookDao bookDao = new BookDao();
    private List<Book> lastResults;

    @Given("the bookstore has {string} by {string} priced {double} with stock {int}")
    public void the_bookstore_has_book(String title, String author, Double price, Integer stock) {
        // ensure table exists and seed defaults
        bookService.init();
        // try to insert this exact book (insert method returns id)
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setIsbn(""); // optional
        b.setPrice(BigDecimal.valueOf(price));
        b.setStock(stock);
        // use DAO insert (if duplicate isbn/name rules allow duplicates)
        bookDao.insert(b);
    }

    @When("the user searches for title {string}")
    public void the_user_searches_for_title(String q) {
        lastResults = bookService.searchByTitle(q);
    }

    @Then("the system shows a result with title {string} and author {string}")
    public void the_system_shows_a_result_with_title_and_author(String title, String author) {
        assertNotNull(lastResults);
        boolean match = lastResults.stream()
                .anyMatch(b -> title.equals(b.getTitle()) && author.equals(b.getAuthor()));
        assertTrue(match, "Expected to find book: " + title + " by " + author);
    }
}
