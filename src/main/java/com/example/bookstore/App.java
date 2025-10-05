package com.example.bookstore;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("   Welcome to Online Bookstore ");
        System.out.println("===============================");
        System.out.println("1. Search Book");
        System.out.println("2. View Cart");
        System.out.println("3. Checkout");
        System.out.println("4. Exit");
        System.out.println("-------------------------------");
        System.out.print("Enter choice (1-4): ");

        try (Scanner sc = new Scanner(System.in)) {
            String choice = sc.nextLine();
            System.out.println("You selected: " + choice);
        }
        System.out.println("Day 3 setup complete ✅ (logic starts Day 4).");
    }
}
