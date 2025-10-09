package com.example.bookstore.service;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.model.Book;
import java.util.List;

/**
 * BookService acts as a bridge between App (UI) and BookDao (DB layer)
 * Handles initialization, search, and logic-level book operations.
 */
public class BookService {

    private final BookDao dao = new BookDao();

    /** Initialize the database (creates table + seed if empty) */
    public void init() {
        dao.createTableIfNotExists();
        dao.seedIfEmpty(); // only inserts if table is empty
    }

    /** Search books by title */
    public List<Book> searchByTitle(String query) {
        return dao.searchByTitle(query);
    }

    /** Search books by author */
    public List<Book> searchByAuthor(String query) {
        return dao.searchByAuthor(query);
    }
}
