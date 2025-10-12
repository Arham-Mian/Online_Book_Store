# Online Bookstore - Requirement Specification

## 1. Introduction

### 1.1 Purpose
The purpose of this project is to design and implement a **console-based Online Bookstore** application where users can:
- Search for books
- View details
- Add items to cart
- Checkout and place orders

This will also serve as a training project to practice Java, DSA, MySQL/DynamoDB, and GitHub.  
The application should be designed in a way that it can later be extended into a **web-based startup** with Amazon affiliate integration.

### 1.2 Scope
- Search books by title or author.
- View book details (title, author, price, availability).
- Manage a shopping cart (add/remove books).
- Place orders and store order details in the database.
- Fetch and display recommended books from DynamoDB.
- Maintain browsing history using LinkedList.
- Future scope: Web-based UI + Amazon affiliate links.

---

## 2. Functional Requirements

1. **Book Management**
    - Add, update, delete, and view books (admin functionality).
    - Search books by title or author.

2. **User Management**
    - Register/login users.
    - Maintain browsing history.

3. **Shopping Cart**
    - Add/remove books from cart.
    - View cart contents.
    - Calculate total price.

4. **Checkout and Orders**
    - Place an order.
    - Save order details in the database.
    - View order history.

5. **Recommendations**
    - Show top recommended books (fetched from DynamoDB).

---

## 3. Non-Functional Requirements

- **Performance:** Book search should be fast.
- **Scalability:** Database design should allow scaling.
- **Security:** Protect user and order data.
- **Usability:** Simple console interface, extendable to web.
- **Maintainability:** Modular design with OOP principles.
- **Version Control:** Codebase maintained on GitHub.
- **Deployment:** Deployable on Linux VM.

---

## 4. System Environment

- **Programming Language:** Java 17
- **Build Tool:** Maven
- **Databases:** MySQL (Books, Users, Orders), DynamoDB (Recommendations)
- **Version Control:** GitHub
- **Testing Frameworks:** JUnit (Unit testing)
- **Deployment:** JAR file deployment

---

## 5. Deliverables

- Requirement Specification Document
- OOAD & Design diagrams (Class, Use Case, ER)
- Java application code with proper structure
- GitHub repository with regular commits
- Test cases (JUnit + Cucumber)
- Deployment on Linux VM
- Final Demo + Project Report

---

## 6. Future Enhancements

- Web-based UI with HTML, CSS, JS
- Integration with Amazon Affiliate program
- Payment gateway integration
- Mobile app support
- ML-based recommendation system

---

