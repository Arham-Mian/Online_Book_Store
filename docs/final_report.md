# 🧾 FINAL PROJECT REPORT

## 📘 Project Title
**Online Bookstore Application using Java, MySQL, DynamoDB, and Jenkins CI/CD**

---

## 👨‍💻 Developer
**Name:** Arham Mian  
**Mentor / Trainer:** Meher Ma'am 
**Duration:** 10 Days  
**Tools & Technologies:** Java, MySQL, DynamoDB, Jenkins, Maven, IntelliJ IDEA

---

## 🧩 1. INTRODUCTION
The **Online Bookstore Application** is a full-stack Java-based mini-project that follows the **Software Development Life Cycle (SDLC)** approach.  
It allows users to search, add, and purchase books online, integrating **MySQL (SQL)** and **DynamoDB (NoSQL)** databases with **CI/CD automation** via Jenkins.  
This project demonstrates the complete software development process — from requirements gathering to deployment — using modern tools and clean coding principles.

---

## 🧱 2. OBJECTIVES
- Develop a modular bookstore application in Java.
- Implement database integration using MySQL and DynamoDB.
- Automate build, test, and deployment using Jenkins.
- Practice Object-Oriented Design and SDLC principles.
- Use data structures (LinkedList, HashMap) effectively.
- Apply DevOps CI/CD in a Java environment.

---

## 🧠 3. SOFTWARE DEVELOPMENT LIFE CYCLE (SDLC)

### **Day 1 – Requirement Gathering**
- Functional Requirements:
    - Search books by title or author.
    - Add books to cart and checkout.
    - Store and retrieve data from databases.
- Non-Functional Requirements:
    - Fast response time.
    - Secure and scalable design.
    - Maintainable and modular structure.

✅ **Deliverable:** Requirement Specification Document

---

### **Day 2 – Object-Oriented Analysis & Design (OOAD)**
- Designed **Class Diagram** (Book, Cart, Order, User).
- Created **Use Case Diagram** showing user-system interaction.
- Designed **ER Diagram** for MySQL schema (books, orders, order_items).
- Prepared **Sequence Diagram** for checkout flow.

✅ **Deliverable:** UML & ER diagrams using PlantUML

---

### **Day 3 – Environment Setup**
- Installed:
    - Java 17
    - Apache Maven
    - MySQL 8
    - IntelliJ IDEA
- Created Maven project structure:  
  src/main/java
  src/test/java
  src/main/resources

- Wrote initial test program → “Hello Bookstore”

✅ **Deliverable:** Project initialized successfully

---

### **Day 4 – Book Search Implementation**
- Created `Book.java` (model) with attributes:  
  `id`, `title`, `author`, `price`, `stock`
- Added `BookDao.java` for MySQL CRUD operations.
- Developed `BookService.java` to implement search logic by title/author.
- Connected to MySQL using JDBC (in `DB.java`).

✅ **Deliverable:** User can search books from MySQL

---

### **Day 5 – Cart & Checkout**
- Implemented `Cart.java` using **HashMap<Book, Integer>**.
- Methods: `addBook()`, `removeBook()`, `calculateTotal()`.
- Developed `CheckoutService.java` and `OrderDao.java` for DB order insertion.
- Linked cart items with orders in MySQL.

✅ **Deliverable:** Add → Checkout → Order saved in DB

---

### **Day 6 – DynamoDB Integration**
- Installed **AWS DynamoDB Local**.
- Created table `RecommendedBooks` for book suggestions.
- Implemented `RecommendationService.java`:
- Fetches user-based recommendations from DynamoDB.
- Added `seed_recommendations.json` for sample test data.

✅ **Deliverable:** DynamoDB recommendation system functional

---

### **Day 7 – Data Structures Implementation**
- Used **LinkedList** to maintain browsing history:
- When a book is viewed, it’s added to the LinkedList.
- Displayed “Recently Viewed Books”.
- Demonstrated data structure usage in real scenario.

✅ **Deliverable:** LinkedList for browsing history implemented

---

### **Day 8 – Testing (Cucumber → JUnit)**
- Migrated from **Cucumber BDD** to **JUnit 5** for compatibility.
- Created test classes:
- `BookServiceTest.java`
- `CartTest.java`
- `CheckoutServiceTest.java`
- All tests executed via Maven Surefire plugin.

✅ **Deliverable:** All test cases passed (`BUILD SUCCESS`)

---

### **Day 9 – DevOps Setup (Jenkins CI/CD)**
- Installed and configured **Jenkins** locally.
- Added tools in Jenkins:
- JDK 21
- Maven 3.9.11
- Installed plugins: Pipeline, JUnit, Git.
- Configured Jenkinsfile:
- **Build:** `mvn clean compile`
- **Test:** `mvn test` + JUnit reports
- **Package:** `mvn package`
- **Deploy:** simulated via echo step.

✅ **Deliverable:** Fully automated CI/CD pipeline success

---

### **Day 10 – Deployment & Demo**
- Packaged app into executable JAR:
  mvn clean package
- Ran application locally:
  java -jar target/bookstore-1.0.0.jar
- Verified:
- MySQL connected successfully
- Orders and Books persisted in DB
- DynamoDB returned recommendations
- Console outputs correct test results

✅ **Deliverable:** Application successfully deployed & tested locally

---

## 🗃️ 4. DATABASE DESIGN

### **MySQL Tables**
```sql
CREATE TABLE books (
id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(100),
author VARCHAR(100),
price DECIMAL(10,2),
stock INT
);

CREATE TABLE orders (
id INT AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(50),
total DECIMAL(10,2),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
id INT AUTO_INCREMENT PRIMARY KEY,
order_id INT,
book_id INT,
quantity INT,
price DECIMAL(10,2),
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (book_id) REFERENCES books(id)
);

| Attribute       | Type   | Description          |
| --------------- | ------ | -------------------- |
| user            | String | Username             |
| recommendations | List   | Book recommendations |

✅ Both databases integrated and tested locally

| Test Class          | Description               | Result   |
| ------------------- | ------------------------- | -------- |
| BookServiceTest     | CRUD & search logic       | ✅ Passed |
| CartTest            | Add/remove books, totals  | ✅ Passed |
| CheckoutServiceTest | Checkout flow + DB insert | ✅ Passed |

Command: mvn test

Output: Tests run: 5
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS

✅ All tests successful

⚙️ 6. CI/CD PIPELINE (Jenkins)

Pipeline Stages:

1.Build: mvn clean compile

2.Test: mvn test

3.Package: mvn package -DskipTests=true

4.Deploy: simulated using echo command

Sample Jenkinsfile:

pipeline {
  agent any
  tools {
    jdk 'JDK 21'
    maven 'Maven 3.9.11'
  }
  stages {
    stage('Build') {
      steps { bat 'mvn clean compile' }
    }
    stage('Test') {
      steps {
        bat 'mvn test'
        junit '**/target/surefire-reports/*.xml'
      }
    }
    stage('Package') {
      steps { bat 'mvn package -DskipTests=true' }
    }
    stage('Deploy (Simulated)') {
      steps { echo '✅ Deployment simulation completed successfully' }
    }
  }
}

✅ Jenkins pipeline automated build, test, and package stages

7. RESULTS

* Online Bookstore successfully implemented.

* Integrated SQL + NoSQL databases.

* Fully automated CI/CD pipeline.

* Passed all JUnit test cases.

* End-to-end SDLC process completed.

✅ Final Outcome: Functional + Tested + Deployable Application

📘 8. CONCLUSION

This project demonstrates end-to-end SDLC in a real-world Java application.
It covers:

* Object-Oriented Design

* Database Integration

* Data Structures

* Automated Testing

* Continuous Integration

By combining Java, SQL, DynamoDB, and Jenkins, this project shows how modern software development integrates coding, testing, and DevOps efficiently.

9. FUTURE ENHANCEMENTS

* Convert backend into REST APIs (Spring Boot).

* Add frontend (HTML, React, or JSP).

* Implement authentication system.

* Integrate online payment simulation.

* Deploy to AWS EC2 or Docker container.

👨‍💻 10. CREDITS
| Role             | Name            |
| ---------------- | --------------- |
| Developer        | Arham Mian      |
| Mentor / Trainer | Meher Ma'am     |

📚 11. REFERENCES

* Oracle Java Documentation

* Apache Maven Docs

* MySQL Reference Manual

* AWS DynamoDB Developer Guide

* Jenkins CI/CD User Guide


✅ 12. SUMMARY

| Component            | Status |
| -------------------- | ------ |
| Core Java Logic      | ✅ Done |
| MySQL Integration    | ✅ Done |
| DynamoDB Integration | ✅ Done |
| Unit Testing         | ✅ Done |
| Jenkins Pipeline     | ✅ Done |
| Deployment           | ✅ Done |
| Documentation        | ✅ Done |


💡 Final Note

“A project is not just about writing code — it’s about designing, testing, and deploying it with purpose.”

Made with ❤️ by Arham Mian


