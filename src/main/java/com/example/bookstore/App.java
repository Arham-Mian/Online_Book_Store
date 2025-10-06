package com.example.bookstore;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Cart;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.CheckoutService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static final BookService bookService = new BookService();
    private static final CheckoutService checkoutService = new CheckoutService();
    private static final BookDao bookDao = new BookDao();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        // bootstrap: books + orders tables & seed
        bookService.init();
        checkoutService.init();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("===============================");
                System.out.println("   Welcome to Online Bookstore ");
                System.out.println("===============================");
                System.out.println("1. Search by Title");
                System.out.println("2. Search by Author");
                System.out.println("3. Add to Cart (by Book ID)");
                System.out.println("4. View Cart");
                System.out.println("5. Checkout");
                System.out.println("6. Exit");
                System.out.println("-------------------------------");
                System.out.print("Enter choice (1-6): ");

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
                    case "3" -> addToCartFlow(sc);
                    case "4" -> printCart();
                    case "5" -> checkoutFlow();
                    case "6" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
                System.out.println();
            }
        }
    }

    private static void addToCartFlow(Scanner sc) {
        try {
            System.out.print("Enter Book ID to add: ");
            long id = Long.parseLong(sc.nextLine().trim());
            System.out.print("Quantity: ");
            int qty = Integer.parseInt(sc.nextLine().trim());
            if (qty <= 0) {
                System.out.println("Quantity must be > 0");
                return;
            }
            Book b = bookDao.findById(id);
            if (b == null) {
                System.out.println("Book not found.");
                return;
            }
            if (!bookDao.hasSufficientStock(id, qty)) {
                System.out.println("Insufficient stock.");
                return;
            }
            cart.addBook(b, qty);
            System.out.println("Added to cart: " + b.getTitle() + " x" + qty);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }

    private static void printCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Your Cart:");
        for (Map.Entry<Book, Integer> e : cart.getItems().entrySet()) {
            Book b = e.getKey();
            int qty = e.getValue();
            System.out.printf("• #%d %s — %s — ₹%s  x%d%n",
                    b.getId(), b.getTitle(), b.getAuthor(), b.getPrice(), qty);
        }
        System.out.println("Total: ₹" + cart.calculateTotal());
    }

    private static void checkoutFlow() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        try {
            long orderId = checkoutService.checkout(null, cart); // userId = null for now
            System.out.println("Order placed successfully! Order ID: " + orderId);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }

    private static void printResults(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        System.out.println("Results:");
        for (Book b : books) {
            System.out.printf("• #%d %s — %s — ₹%s (stock: %d)%n",
                    b.getId(), b.getTitle(), b.getAuthor(), b.getPrice(), b.getStock());
        }
        System.out.println("Tip: Use option 3 to add by Book ID.");
    }
}
