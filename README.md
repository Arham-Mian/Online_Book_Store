# 📚 Online Bookstore Application — Java + MySQL + DynamoDB + Jenkins CI/CD

Welcome to the **Online Bookstore Application**, a complete **Java-based full-stack mini-project**  
designed to demonstrate the **Software Development Life Cycle (SDLC)** from **Requirement Gathering to Deployment**.

This application allows users to:
- 🔍 **Search** for books by title or author
- 🛒 **Add** books to a shopping cart
- 💳 **Checkout** to place an order (stored in MySQL)
- 🤖 **View recommendations** fetched from DynamoDB (NoSQL)
- 🧪 Run automated tests with **JUnit**
- ⚙️ Build, test, and deploy via **Jenkins CI/CD**

---

## 🧩 1. Project Summary

This project was developed as part of a **10-day structured SDLC learning journey**,  
covering everything from software design diagrams to database integration and automation pipelines.

| **Day** | **Topic** | **Summary** |
|----------|------------|-------------|
| 🧠 **Day 1** | Requirement Gathering | Defined all functional and non-functional requirements. |
| 🧱 **Day 2** | OOAD & Design | Designed UML (Class, Use Case, ER) diagrams using PlantUML. |
| ⚙️ **Day 3** | Environment Setup | Installed Java 17, Maven, MySQL; created IntelliJ project structure. |
| 🔍 **Day 4** | Book Search | Built `BookService` and DAO for CRUD and search operations. |
| 🛒 **Day 5** | Cart & Checkout | Implemented `Cart` and `CheckoutService` connected to MySQL. |
| ☁️ **Day 6** | DynamoDB Integration | Configured AWS SDK to fetch “Recommended Books” from DynamoDB Local. |
| 🔁 **Day 7** | Data Structures | Added browsing history feature using a LinkedList. |
| 🧪 **Day 8** | Testing | Replaced Cucumber BDD with JUnit 5 test cases. |
| 🔧 **Day 9** | Jenkins CI/CD | Automated build, test, and reporting pipeline with Jenkinsfile. |
| 🚀 **Day 10** | Deployment & Demo | Packaged the app, performed manual testing, and finalized documentation. |

---

## 🧠 2. Technologies Used

| **Category** | **Tools / Tech** |
|---------------|------------------|
| 💻 **Programming Language** | Java 17 |
| 📦 **Build Tool** | Apache Maven |
| 🧪 **Testing Framework** | JUnit 5 (earlier Cucumber BDD) |
| 🗄️ **Relational Database** | MySQL 8 |
| ☁️ **NoSQL Database** | AWS DynamoDB Local |
| ⚙️ **DevOps / CI-CD** | Jenkins |
| 🧑‍💻 **IDE** | IntelliJ IDEA |
| 🎨 **Design Diagrams** | PlantUML |
| 🔗 **Version Control** | Git + GitHub |

---

## 📁 3. Project Structure

Online_Book_Store/
├── src/
│ ├── main/java/com/example/bookstore/
│ │ ├── App.java # Main entry point
│ │ ├── config/DB.java # MySQL DB connection class
│ │ ├── model/ # POJO Classes
│ │ │ ├── Book.java
│ │ │ ├── Cart.java
│ │ │ ├── Order.java
│ │ │ └── User.java
│ │ ├── dao/ # Data Access Layer
│ │ │ ├── BookDao.java
│ │ │ ├── OrderDao.java
│ │ │ └── CartDao.java
│ │ ├── service/ # Business Logic Layer
│ │ │ ├── BookService.java
│ │ │ ├── CheckoutService.java
│ │ │ └── RecommendationService.java
│ │ └── bdd/ # (Deprecated) Cucumber Tests
│ └── test/java/com/example/bookstore/test/
│ ├── BookServiceTest.java
│ ├── CartTest.java
│ └── CheckoutServiceTest.java
│
├── docs/
│ ├── sql/
│ │ ├── 01_schema.sql
│ │ └── 02_seed.sql
│ ├── dynamo/
│ │ └── recommendations.json
│ ├── diagrams/
│ │ ├── class_diagram.puml
│ │ ├── usecase_diagram.puml
│ │ ├── er_diagram.puml
│ │ └── sequence_diagram.puml
│ ├── jenkins/
│ │ ├── Jenkinsfile
│ │ ├── build_logs.txt
│ │ └── pipeline_screenshot.png
│ └── final_report.docx
│
├── pom.xml
├── Jenkinsfile
├── .gitignore
└── README.md


---

## 🧾 4. Core Features

✅ Search books by **title or author**  
✅ Add / Remove books from cart  
✅ Checkout → generates order record in MySQL  
✅ Recommended Books from DynamoDB Local  
✅ Recently Browsed (LinkedList data structure)  
✅ Full CRUD operations (Create, Read, Update, Delete)  
✅ Automated JUnit testing  
✅ Jenkins CI/CD integration

---

## 🗃️ 5. Database Setup (MySQL)

Run these queries in **MySQL Workbench** or CLI:

```sql
CREATE DATABASE IF NOT EXISTS bookstore_fresh;
USE bookstore_fresh;

CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(100),
  price DECIMAL(10,2),
  stock INT
);

CREATE TABLE orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(100),
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

INSERT INTO books (title, author, price, stock)
VALUES
('Clean Code', 'Robert C. Martin', 450.00, 10),
('Design Patterns', 'Erich Gamma', 550.00, 8),
('Refactoring', 'Martin Fowler', 600.00, 5);
