package com.example.bookstore.model;
import java.util.Objects;
import java.math.BigDecimal;

public class Book {
    // ... existing imports/package


// class Book { ... your fields & getters/setters ...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id; // compare by primary key
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private long id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private int stock;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
