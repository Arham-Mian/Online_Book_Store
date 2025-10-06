package com.example.bookstore.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    // key = Book, value = quantity
    private final Map<Book, Integer> items = new HashMap<>();

    public void addBook(Book book, int qty) {
        if (book == null || qty <= 0) return;
        items.merge(book, qty, Integer::sum);
    }

    public void removeBook(Book book) {
        if (book == null) return;
        items.remove(book);
    }

    public Map<Book, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Book, Integer> e : items.entrySet()) {
            BigDecimal price = e.getKey().getPrice();
            int qty = e.getValue();
            total = total.add(price.multiply(BigDecimal.valueOf(qty)));
        }
        return total;
    }
}
