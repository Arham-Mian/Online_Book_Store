package com.example.bookstore.model;

import java.util.LinkedList;

public class BrowsingHistory {

    private final LinkedList<Book> history = new LinkedList<>();
    private final int MAX_SIZE = 5;

    public void add(Book book) {
        // remove if already exists (avoid duplicates)
        history.removeIf(b -> b.getId() == book.getId());
        // add to front
        history.addFirst(book);
        // limit to 5 recent
        if (history.size() > MAX_SIZE) {
            history.removeLast();
        }
    }

    public LinkedList<Book> getHistory() {
        return history;
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void clear() {
        history.clear();
    }
}
