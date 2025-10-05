package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;

import java.util.List;
import java.util.Scanner;

public class App {

    private static final BookService bookService = new BookService();

    public static void main(String[] args) {
        // DB bootstrap (table + seed)
        bookService.init();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("===============================");
                System.out.println("   Welcome to Online Bookstore ");
                System.out.println("===============================");
                System.out.println("1. Search by Title");
                System.out.println("2. Search by Author");
                System.out.println("3. Exit");
                System.out.println("-------------------------------");
                System.out.print("Enter choice (1-3): ");

                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter title keyword: ");
                        String q = sc.nextLine().trim();
                        List<Book> byTitle = bookService.searchByTitle(q);
                        printResults(byTitle);
                    }
                    case "2" -> {
                        System.out.print("Enter author keyword: ");
                        String q = sc.nextLine().trim();
                        List<Book> byAuthor = bookService.searchByAuthor(q);
                        printResults(byAuthor);
                    }
                    case "3" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
                System.out.println();
            }
        }
    }

    private static void printResults(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        System.out.println("Results:");
        for (Book b : books) {
            System.out.printf("• %s — %s — ₹%s (stock: %d)%n",
                    b.getTitle(), b.getAuthor(), b.getPrice(), b.getStock());
        }
    }
}
