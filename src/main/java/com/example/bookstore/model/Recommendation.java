package com.example.bookstore.model;

public class Recommendation {
    private String userId;   // partition key
    private int rank;        // sort key (1..N)
    private long bookId;     // link to books table
    private String title;
    private String author;

    public Recommendation() {}
    public Recommendation(String userId, int rank, long bookId, String title, String author) {
        this.userId = userId;
        this.rank = rank;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getUserId() { return userId; }
    public int getRank() { return rank; }
    public long getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void setUserId(String userId) { this.userId = userId; }
    public void setRank(int rank) { this.rank = rank; }
    public void setBookId(long bookId) { this.bookId = bookId; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
}
