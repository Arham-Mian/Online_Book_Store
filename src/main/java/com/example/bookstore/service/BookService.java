package com.example.bookstore.service;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.model.Book;

import java.util.List;

public class BookService {
    private final BookDao dao = new BookDao();

    /** Initialize schema and seed defaults */
    public void init() {
        dao.createTableIfNotExists();
        dao.seedDefaults(); // changed from seedIfEmpty()
    }

    public List<Book> searchByTitle(String q) {
        return dao.searchByTitle(q);
    }

    public List<Book> searchByAuthor(String q) {
        return dao.searchByAuthor(q);
    }
}
