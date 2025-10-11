<h1>🧾 FINAL PROJECT REPORT</h1>

<h2>📘 Project Title</h2>
<p><b>Online Bookstore Application using Java, MySQL, DynamoDB, and Jenkins CI/CD</b></p>

<hr/>

<h2>👨‍💻 Developer Details</h2>
<ul>
  <li><b>Name:</b> Arham Mian</li>
  <li><b>Mentor / Trainer:</b> Meher Ma'am</li>
  <li><b>Duration:</b> 10 Days</li>
  <li><b>Tools & Technologies:</b> Java, MySQL, DynamoDB, Jenkins, Maven, IntelliJ IDEA</li>
</ul>

<hr/>

<h2>🧩 1. INTRODUCTION</h2>

<p>
The <b>Online Bookstore Application</b> is a full-stack Java project that demonstrates how an e-commerce platform can be designed and developed using modern software engineering practices.  
It follows the complete <b>Software Development Life Cycle (SDLC)</b> — from requirement gathering and analysis to coding, testing, and deployment.
</p>

<p>
This system enables users to <b>search books, view details, add them to a cart, and place orders</b>.  
It integrates <b>MySQL</b> for transactional data such as orders and inventory, and <b>AWS DynamoDB Local</b> for book recommendations, showcasing a hybrid SQL + NoSQL approach.
</p>

<p>
The application is built with <b>Java 17</b> and managed using <b>Maven</b>, following a layered architecture that separates the <b>Model</b>, <b>DAO</b>, <b>Service</b>, and <b>Configuration</b> layers.  
This design ensures high modularity, easier testing, and long-term scalability.  
It also applies data structures like <b>HashMap</b> and <b>LinkedList</b> for efficient cart management and browsing history.
</p>

<p>
To maintain quality, <b>JUnit 5</b> has been used for unit testing, while <b>Jenkins</b> automates the build, test, and packaging process through a CI/CD pipeline.  
Together, these tools ensure that the project is <b>reliable, maintainable, and production-ready</b>.
</p>

<p>
In short, the Online Bookstore Project is not just a Java program — it’s a demonstration of how modern development combines <b>Object-Oriented Programming</b>, <b>Database Design</b>, and <b>DevOps Automation</b> into one cohesive workflow.  
It represents a complete learning cycle, turning a simple idea — <i>“selling books online”</i> — into a fully functional, automated, and tested application.
</p>


<hr/>

<h2>📂 2. PROJECT OVERVIEW</h2>

<p>
After the initial planning and introduction, let’s take a quick look at the overall structure of the project.  
The <b>Online Bookstore</b> follows a clean and layered architecture built on the <b>Maven</b> standard directory layout.  
Each folder and file has a dedicated purpose — from documentation and database scripts to the source code and configuration files.
</p>

<p>
To understand how all these components are organized and connected, we can explore the main repository structure through the project’s <b>README.md</b> file.  
It provides a clear outline of the technologies used, the directory hierarchy, and instructions on how to build and run the application.
</p>

<p>
📖 <b>Click below to view the complete project overview:</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/README.md">Open README.md (Project Overview)</a>
</p>

<p>
The README file serves as a visual guide — giving an at-a-glance view of the application’s structure and helping users quickly understand the flow before diving deeper into specific modules.  
It also highlights how the system integrates MySQL for relational data, DynamoDB for recommendations, and Jenkins for CI/CD automation.
</p>

<hr/>

<h2>📋 3. REQUIREMENT SPECIFICATION</h2>

<p>
Before development began, a detailed requirement analysis was performed to identify both the <b>functional</b> and <b>non-functional</b> aspects of the system.  
This was a crucial stage in the <b>Software Development Life Cycle (SDLC)</b>, ensuring that every feature and workflow was clearly defined before moving to the design and implementation phases.
</p>

<p>
The <b>requirements.md</b> document captures all key objectives — including the book search feature, cart and checkout functionality, database connections, and system performance goals.  
It also outlines scalability, security, and maintainability factors to ensure a smooth user experience and long-term stability.
</p>

<p>
📄 <b>Click below to view detailed requirements:</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/requirements.md">Open requirements.md (Project Requirements)</a>
</p>

<p>
By defining these requirements early, the foundation for development was set — leading to a structured design, cleaner implementation, and easier integration of features in later stages of the project.
</p>


<hr/>

<hr/>

<hr/>

<h2>🧩 4. SYSTEM DESIGN</h2>

<p>
The <b>System Design</b> phase transforms all collected requirements into a clear structural and behavioral model using <b>UML (Unified Modeling Language)</b>.  
This step bridges the gap between what the system should do (requirements) and how it will do it (implementation).  
It provides developers, testers, and designers with a common understanding of the system’s architecture, flow, and data management.
</p>

<p>
For the <b>Online Bookstore Application</b>, three major UML diagrams were created — each focusing on a different perspective of the system:
</p>

<ul>
  <li><b>Use Case Diagram</b> – shows how users interact with the system and what functionalities are accessible to each type of user.</li>
  <li><b>Class Diagram</b> – illustrates the main classes, their attributes, methods, and the relationships among them.</li>
  <li><b>ER Diagram</b> – maps the logical model into the physical database structure, defining tables, keys, and relationships.</li>
</ul>

<p>
Together, these diagrams form the visual foundation of the project’s architecture —  
from <b>user interaction</b> to <b>business logic</b> to <b>data storage</b>.  
Let’s explore them one by one.
</p>

<hr/>

<h3>🎭 4.1 Use Case Diagram</h3>

<p>
The <b>Use Case Diagram</b> represents the external view of the system —  
it shows how different <b>actors</b> (users) interact with the application and what operations they can perform.  
For this bookstore, we have two actors:
</p>

<ul>
  <li><b>Guest:</b> Can browse the catalog, search for books by title or author, and view detailed information about each book.</li>
  <li><b>Registered User:</b> Can do everything a Guest can, plus additional actions like adding books to the cart, viewing the cart, placing an order (checkout), and accessing personalized recommendations.</li>
</ul>

<p>
In the current console-based version, user registration and authentication are not implemented —  
the system assumes a <b>default registered user</b> from pre-seeded database records.  
However, the design includes both actors to demonstrate how the application could scale into a full-fledged web version in the future, supporting login and personalized sessions.
</p>

<p>
📄 <b>View Use Case Diagram Source (PlantUML):</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/design/use-case-diagram.puml">docs/design/use-case-diagram.puml</a>
</p>

<p>
🖼️ <b>View Rendered Use Case Diagram (PNG):</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/design/use-case-diagram.png">docs/design/use-case-diagram.png</a>
</p>

<p>
In summary, this diagram provides a <b>functional overview</b> of the system:  
who the users are and which functionalities belong to each.  
It ensures that all high-level requirements (like search, checkout, and recommendations) are connected to at least one user actor, leaving no orphan features in the design.
</p>

<details>
  <summary><b>🎙️ Presentation Tip (if trainer asks about Guest flow)</b></summary>
  <p>
  You can say:  
  “The Guest and Registered User are conceptual roles. Currently, both share the same working flow in code because the system assumes a pre-registered user.  
  Guest functionalities — such as searching and viewing books — are already part of the demo.  
  In a future web version, I can easily disable cart and checkout options for Guest users.”  
  </p>
</details>

<hr/>

<h3>🏗️ 4.2 Class Diagram</h3>

<p>
Once the user actions were identified in the Use Case Diagram, the next step was to design the internal structure of the application using a <b>Class Diagram</b>.  
This diagram defines the <b>main building blocks</b> of the code — classes, their properties, operations, and the relationships among them.
</p>

<p>
Each class in the diagram directly maps to a Java class in the <code>src/main/java/com/example/bookstore/model</code> package:
</p>

<ul>
  <li><b>Book:</b> Represents a book entity with attributes like <code>id</code>, <code>title</code>, <code>author</code>, <code>isbn</code>, <code>price</code>, and <code>stock</code>.</li>
  <li><b>User:</b> Represents a customer or registered user, storing <code>username</code>, <code>email</code>, and <code>passwordHash</code>.</li>
  <li><b>Cart:</b> Manages a user’s temporary book selections using <code>Map&lt;Book,Integer&gt;</code> and provides methods like <code>addBook()</code>, <code>removeBook()</code>, and <code>calculateTotal()</code>.</li>
  <li><b>Order:</b> Represents a completed purchase, linked to a specific user.</li>
  <li><b>OrderItem:</b> Represents each individual book entry within an order, tracking quantity and price.</li>
</ul>

<p>
The diagram also captures the relationships among these classes:
</p>

<ul>
  <li><b>User → Order:</b> One user can place many orders.</li>
  <li><b>Order → OrderItem:</b> Each order can contain multiple order items.</li>
  <li><b>Cart → Book:</b> Aggregation relationship — the cart temporarily contains book objects.</li>
</ul>

<p>
This design ensures clean separation between <b>business logic</b> and <b>data representation</b>.  
For example, <code>Cart</code> performs in-memory calculations, while <code>OrderDao</code> persists finalized data to MySQL.
</p>

<p>
📄 <b>View Class Diagram Source (PlantUML):</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/design/class-diagram.puml">docs/design/class-diagram.puml</a>
</p>

<p>
🖼️ <b>View Rendered Class Diagram (PNG):</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/design/class-diagram.png">docs/design/class-diagram.png</a>
</p>

<p>
The Class Diagram directly influenced how the project’s Java packages were organized — separating <b>model</b>, <b>dao</b>, and <b>service</b> layers for better modularity and maintainability.  
It acts as a blueprint for the object-oriented design and ensures that the system remains flexible for future expansion.
</p>

<hr/>

<h3>🗄️ 4.3 ER (Entity–Relationship) Diagram</h3>

<p>
The <b>ER Diagram</b> represents the backend data model used in the <b>MySQL database</b>.  
It shows how entities (tables) relate to each other through <b>primary keys (PK)</b> and <b>foreign keys (FK)</b>.  
This diagram ensures that the application’s data layer is consistent, normalized, and optimized for relational queries.
</p>

<p>
Key database tables and their roles are as follows:
</p>

<ul>
  <li><b>books:</b> Stores book details — <code>id</code>, <code>title</code>, <code>author</code>, <code>isbn</code>, <code>price</code>, <code>stock</code>.</li>
  <li><b>users:</b> Contains registered user information — <code>id</code>, <code>username</code>, <code>email</code>, and <code>password_hash</code>.</li>
  <li><b>orders:</b> Captures each purchase — links to <code>users</code> via <code>user_id</code>.</li>
  <li><b>order_items:</b> Connects each order to specific books via <code>order_id</code> and <code>book_id</code>.</li>
  <li><b>carts</b> and <b>cart_items:</b> Optional tables for extending the cart feature to persistent storage.</li>
</ul>

<p>
Foreign key relationships ensure referential integrity:
</p>

<ul>
  <li><code>orders.user_id → users.id</code></li>
  <li><code>order_items.order_id → orders.id</code></li>
  <li><code>order_items.book_id → books.id</code></li>
</ul>

<p>
📄 <b>View ER Diagram Source (PlantUML):</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/design/er-diagram.puml">docs/design/er-diagram.puml</a>
</p>

<p>
🖼️ <b>View Rendered ER Diagram (PNG):</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/design/er-diagram.png">docs/design/er-diagram.png</a>
</p>

<p>
This ER diagram aligns perfectly with the <b>01_schema.sql</b> and <b>02_seed.sql</b> scripts inside the <code>docs/sql</code> folder.  
It guarantees that every data entity from the Class Diagram (like Book, Order, and User) has a proper table representation and all relationships are consistent.
</p>

<hr/>

<h3>📘 Summary of Design Phase</h3>

<ul>
  <li><b>Use Case Diagram</b> – defines the external interactions and functional boundaries of the system.</li>
  <li><b>Class Diagram</b> – translates user actions into classes, logic, and relationships within the code.</li>
  <li><b>ER Diagram</b> – ensures that data is organized, consistent, and linked according to relational rules.</li>
</ul>

<p>
Together, these three diagrams form the heart of the system architecture.  
They ensure that user interactions, business logic, and data management remain perfectly synchronized —  
making the <b>Online Bookstore Application</b> a scalable, maintainable, and real-world-ready project.
</p>


<hr/>

<h2>🗃️ 5. DATABASE DESIGN</h2>

<p>
The <b>Database Design</b> phase defines how application data is structured, stored, and accessed.  
The <b>Online Bookstore</b> project uses a <b>hybrid database architecture</b> — combining the power of both <b>MySQL (SQL)</b> and <b>AWS DynamoDB Local (NoSQL)</b>.  
This approach demonstrates how transactional and non-transactional data can coexist efficiently within the same system.
</p>

<p>
In this architecture:
</p>

<ul>
  <li><b>MySQL</b> handles structured, relational data — books, users, orders, and order items.</li>
  <li><b>DynamoDB</b> manages semi-structured data — book recommendations for individual users.</li>
</ul>

<p>
Both data sources complement each other, ensuring that <b>MySQL</b> maintains consistency and <b>DynamoDB</b> provides scalability and flexibility.
</p>

<hr/>

<h3>🧾 5.1 MySQL Schema Design</h3>

<p>
MySQL serves as the primary data store for all core bookstore transactions.  
It ensures <b>data integrity</b> using constraints like <code>PRIMARY KEY</code>, <code>FOREIGN KEY</code>, and <code>NOT NULL</code>.
</p>

<p>
📄 <b>View SQL Schema Script:</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/sql/01_schema.sql">docs/sql/01_schema.sql</a>
</p>

<p>
This script creates all relational tables and defines their relationships.
</p>

<h4>📚 Key Tables Overview</h4>

<ul>
  <li>
    <b>books</b> – stores book details.<br/>
    <code>
    id BIGINT PRIMARY KEY AUTO_INCREMENT,<br/>
    title VARCHAR(255), author VARCHAR(255), isbn VARCHAR(20), price DECIMAL(10,2), stock INT
    </code><br/>
    ✅ Maintains inventory with title, author, and price.
  </li>
  <li>
    <b>users</b> – stores registered user details.<br/>
    <code>
    id BIGINT PRIMARY KEY AUTO_INCREMENT,<br/>
    username VARCHAR(100) UNIQUE,<br/>
    email VARCHAR(255), password_hash VARCHAR(255)
    </code><br/>
    ✅ Ensures unique usernames and secure password storage.
  </li>
  <li>
    <b>orders</b> – stores purchase metadata linked to users.<br/>
    <code>
    id BIGINT PRIMARY KEY AUTO_INCREMENT,<br/>
    user_id BIGINT,<br/>
    created_at DATETIME,<br/>
    total DECIMAL(10,2)
    </code><br/>
    ✅ Uses <code>FOREIGN KEY (user_id)</code> referencing <code>users(id)</code>.
  </li>
  <li>
    <b>order_items</b> – stores individual book entries within an order.<br/>
    <code>
    id BIGINT PRIMARY KEY AUTO_INCREMENT,<br/>
    order_id BIGINT,<br/>
    book_id BIGINT,<br/>
    quantity INT,<br/>
    price DECIMAL(10,2)
    </code><br/>
    ✅ Uses <code>FOREIGN KEY (order_id)</code> and <code>FOREIGN KEY (book_id)</code> for relational integrity.
  </li>
  <li>
    <b>carts</b> and <b>cart_items</b> – optional tables for persistent cart storage.<br/>
    Used if the cart state needs to be saved between sessions.
  </li>
</ul>

<p>
This schema design ensures that the bookstore system supports a complete e-commerce workflow — from browsing to checkout to order management —  
while maintaining data consistency, normalization, and referential integrity.
</p>

<hr/>

<h3>💾 5.2 MySQL Seed Data</h3>

<p>
After designing the schema, the next step is to populate the database with some initial data for testing and demonstration.  
The <b>02_seed.sql</b> script performs this task by inserting predefined records into the <b>books</b> and <b>users</b> tables.
</p>

<p>
📄 <b>View Seed Data Script:</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/sql/02_seed.sql">docs/sql/02_seed.sql</a>
</p>

<h4>🌱 Example Seed Data</h4>

<ul>
  <li><b>Books:</b> Fictional titles such as “Java Basics”, “Clean Code”, and “Effective Java” with sample authors, ISBNs, and prices.</li>
  <li><b>Users:</b> Demo users (e.g., <i>john_doe</i>, <i>emma_smith</i>) created with basic credentials for testing checkout and order flow.</li>
</ul>

<p>
This seed data ensures that the application can run immediately after setup —  
allowing users to search, add books to a cart, and simulate checkout without manually entering data.
</p>

<p>
Additionally, it enables the developer to verify SQL joins and foreign key relationships between <b>orders</b> and <b>order_items</b> right from the start.
</p>

<hr/>

<h3>⚡ 5.3 DynamoDB Integration</h3>

<p>
In addition to MySQL, this project integrates <b>AWS DynamoDB Local</b> — a NoSQL database that stores non-relational data.  
Its main purpose in the Online Bookstore is to handle <b>personalized book recommendations</b> for users.
</p>

<p>
📄 <b>View DynamoDB JSON Seed File:</b><br/>
➡️ <a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/docs/dynamo/seed_recommendations.json">docs/dynamo/seed_recommendations.json</a>
</p>

<p>
The <code>seed_recommendations.json</code> file acts as sample input for DynamoDB.  
Each record inside this JSON contains a user ID and a list of recommended book IDs based on past purchases or browsing history.
</p>

<h4>🧠 Example Structure</h4>

<pre>
{
  "userId": "user_101",
  "recommendations": [
    { "bookId": "B001", "title": "Clean Code" },
    { "bookId": "B002", "title": "Effective Java" }
  ]
}
</pre>

<ul>
  <li>Each document represents one user’s personalized recommendation set.</li>
  <li>The <code>RecommendationService</code> class fetches these records using the <code>AWS SDK</code>.</li>
  <li>The <code>Dynamo.java</code> configuration file sets up the local DynamoDB connection at <code>localhost:8000</code>.</li>
</ul>

<p>
This integration showcases how traditional SQL databases and modern NoSQL stores can coexist in a hybrid Java application.  
MySQL ensures reliability for core data, while DynamoDB adds dynamic features like real-time recommendations.
</p>

<hr/>

<h3>🔄 5.4 Data Synchronization Between SQL & NoSQL</h3>

<p>
The combination of MySQL and DynamoDB represents a real-world enterprise scenario:
</p>

<ul>
  <li>MySQL manages <b>transactions and persistence</b> — orders, users, and books.</li>
  <li>DynamoDB handles <b>non-relational data</b> — user-specific behavior and recommendations.</li>
</ul>

<p>
In the application workflow:
</p>

<ol>
  <li>User searches or purchases books → data recorded in MySQL.</li>
  <li>The system then references DynamoDB to suggest similar titles.</li>
  <li>The <code>RecommendationsDao</code> bridges both worlds — reading from DynamoDB and serving data to the service layer.</li>
</ol>

<p>
This design balances <b>consistency</b> (SQL) and <b>scalability</b> (NoSQL),  
ensuring that the application remains performant and future-ready.
</p>

<hr/>

<h3>📘 Summary of Database Design</h3>

<ul>
  <li><b>01_schema.sql:</b> Defines MySQL tables, constraints, and relationships.</li>
  <li><b>02_seed.sql:</b> Populates initial demo data for testing and validation.</li>
  <li><b>seed_recommendations.json:</b> Holds sample recommendation data for DynamoDB Local.</li>
</ul>

<p>
Together, these components make the Online Bookstore’s database layer robust, flexible, and reflective of real-world architecture.  
It not only supports core operations like search and checkout but also enhances the user experience through data-driven insights and recommendations.
</p>

<h2 id="main-coding">💻 7. MAIN CODING SECTION</h2>

<p>
This section explains the <b>main code architecture</b> of the Online Bookstore application.  
It demonstrates how the application connects different layers — configuration, model, DAO, and service — through a single entry point class, <b>App.java</b>.  
The code follows modular programming and layered design for clarity and scalability.
</p>

<ul>
  <li><b>App.java</b> → Entry point and user interface control.</li>
  <li><b>Service Layer</b> → Business logic (BookService, CheckoutService, RecommendationsService).</li>
  <li><b>DAO Layer</b> → Database operations (BookDao, OrderDao, RecommendationsDao).</li>
  <li><b>Model Layer</b> → Core entities (Book, Cart, Recommendation, User, etc.).</li>
  <li><b>Config Layer</b> → Database connection setup (DB.java for MySQL, Dynamo.java for DynamoDB).</li>
</ul>

<hr/>

<h3 id="app-class">🧩 7.1 Application Entry Point — <code>App.java</code></h3>

<p>
The <b>App.java</b> class is the <b>heart of the Online Bookstore</b>.  
It manages initialization, user interactions, and the orchestration between multiple components.
</p>

<p><b>On startup, it initializes:</b></p>
<ul>
  <li><b>MySQL</b> tables via <code>BookService.init()</code> and <code>CheckoutService.init()</code> (books, orders, order_items).</li>
  <li><b>DynamoDB Local</b> via <code>RecommendationsService.init()</code> (recommendations table).</li>
  <li>Optional demo data seeding for a smooth walkthrough.</li>
</ul>

<p><b>Then it exposes a simple console menu to:</b></p>
<ul>
  <li>Search books by <b>title</b> or <b>author</b> (delegates to <code>BookService</code>).</li>
  <li>Add books to an in-memory <b>Cart</b>, view the cart, and <b>checkout</b> (delegates to <code>CheckoutService</code> which persists to MySQL).</li>
  <li>View personalized <b>recommendations</b> fetched from <b>DynamoDB Local</b> (via <code>RecommendationsService</code>).</li>
  <li>Track <b>browsing history</b> using a LinkedList-backed helper (<code>BrowsingHistory</code>).</li>
</ul>

<p><b>Key orchestration responsibilities of <code>App.java</code>:</b></p>
<ul>
  <li>Maintains a single shared <code>Cart</code> and <code>BrowsingHistory</code> for the session.</li>
  <li>Validates user input and handles graceful error messages (e.g., invalid numbers, empty cart).</li>
  <li>Bridges UI actions to the appropriate <b>Service</b> methods; services in turn call <b>DAOs</b> which use <b>Config</b> connections.</li>
</ul>

<p style="margin-top:8px;">
<b>Architecture flow:</b><br/>
<code>User → App.java (menu) → Services → DAOs → Config (DB/Dynamo clients) → Databases</code>
</p>

<p style="margin-top:12px;">
🔗 <b>GitHub Source (App.java):</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/App.java">
View App.java on GitHub
</a>
</p>
<hr/>

<h3 id="db-class">🗄️ 7.2 Database Configuration — <code>DB.java</code></h3>

<p>
The <b>DB.java</b> class is the central configuration file for connecting the Online Bookstore application to the <b>MySQL</b> database.  
It provides a single, reusable method for obtaining a <code>Connection</code> object, ensuring a consistent and secure database connection across the application.
</p>

<p>
This configuration follows a flexible priority-based approach for resolving credentials:
</p>

<ol>
  <li><b>System Properties</b> — Passed using JVM flags such as <code>-Ddb.url</code>, <code>-Ddb.user</code>, and <code>-Ddb.pass</code>.</li>
  <li><b>Environment Variables</b> — Read from <code>DB_URL</code>, <code>DB_USER</code>, and <code>DB_PASS</code>.</li>
  <li><b>Local Defaults</b> — Used during development (local MySQL setup).</li>
</ol>

<p>
The class is designed as <b>final</b> and has a <b>private constructor</b> to prevent instantiation — meaning it is purely a configuration utility class.
</p>

<p>
When the application starts, it loads the <b>MySQL JDBC Driver</b> and attempts to connect to the database using the resolved credentials.  
If the connection is successful, it prints diagnostic details (like schema name and connection source) to the console.
</p>

<p><b>Key Highlights:</b></p>
<ul>
  <li>Ensures only one database configuration logic exists throughout the project.</li>
  <li>Automatically picks up configuration from environment or runtime properties.</li>
  <li>Encapsulates <code>DriverManager.getConnection()</code> for safe, consistent usage.</li>
  <li>Provides clear console feedback for debugging connection issues.</li>
</ul>

<p><b>Default Connection Example:</b></p>
<pre>
jdbc:mysql://localhost:3306/bookstore?useSSL=false&serverTimezone=UTC  
User: bookapp  
Password: BookApp@123
</pre>

<p>
This design ensures that developers can easily switch environments (e.g., from local to Jenkins or cloud) without changing any code — only by modifying environment variables or runtime flags.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/config/DB.java">
View DB.java on GitHub
</a>
</p>

<hr/>

<h3 id="dynamo-class">⚡ 7.3 NoSQL Configuration — <code>Dynamo.java</code></h3>

<p>
The <b>Dynamo.java</b> class handles configuration and client creation for the <b>AWS DynamoDB Local</b> service used in this project.  
It abstracts away all DynamoDB setup logic, ensuring the rest of the code interacts with DynamoDB through a single, pre-configured client.
</p>

<p>
Unlike MySQL, DynamoDB is a <b>NoSQL</b> database, ideal for unstructured or semi-structured data — in this case, personalized <b>book recommendations</b>.
</p>

<p>
The <code>Dynamo.java</code> class uses the official <b>AWS SDK v2</b> and builds a <code>DynamoDbClient</code> instance with:
</p>

<ul>
  <li>A <b>local endpoint</b> (<code>http://localhost:8000</code>) for development.</li>
  <li>A default <b>region</b> (<code>us-east-1</code>).</li>
  <li><b>Static dummy credentials</b> since no AWS authentication is needed for local mode.</li>
  <li>A lightweight <b>HTTP client</b> (<code>UrlConnectionHttpClient</code>) for quick API communication.</li>
</ul>

<p>
To make the configuration environment-independent, it uses the helper method:
</p>

<pre><code>getEnv("DDB_ENDPOINT", DEFAULT_ENDPOINT)</code></pre>

<p>
This method checks if custom environment variables like <code>DDB_ENDPOINT</code> or <code>DDB_REGION</code> exist —  
if not, it falls back to local defaults.  
This allows the same code to run seamlessly both on a developer machine and in a CI/CD environment.
</p>

<p><b>Key Highlights:</b></p>
<ul>
  <li>Encapsulates all DynamoDB setup inside one reusable static method (<code>client()</code>).</li>
  <li>Implements lazy initialization — the client is created only once (singleton style).</li>
  <li>Provides clean separation between application logic and AWS SDK configuration.</li>
  <li>Can easily switch to an actual AWS environment by changing endpoint and credentials.</li>
</ul>

<p>
Together with <code>DB.java</code>, this file completes the <b>Config Layer</b> of the application — providing seamless database connectivity  
for both SQL (MySQL) and NoSQL (DynamoDB) operations.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/config/Dynamo.java">
View Dynamo.java on GitHub
</a>
</p>
<hr/>

<h3 id="bookdao-class">📚 7.4 Data Access Layer — <code>BookDao.java</code></h3>

<p>
The <b>BookDao.java</b> class is responsible for all direct interactions with the <b>MySQL database</b> related to the <b>books</b> table.  
It implements a clean separation between the business logic and database layer — ensuring the rest of the application does not directly use SQL queries.
</p>

<p>
This class performs operations such as creating tables, inserting default records, searching, and verifying stock levels.  
It uses the <b>DB.java</b> configuration class to establish connections safely and efficiently.
</p>

<p><b>Key Functionalities:</b></p>
<ul>
  <li><b>Table Creation:</b> Automatically creates the <code>books</code> table if it doesn’t exist, ensuring smooth setup.</li>
  <li><b>Data Seeding:</b> Populates the database with a few default books like “Clean Code” and “Effective Java” when the table is empty.</li>
  <li><b>Searching:</b> Provides two search methods — <code>searchByTitle()</code> and <code>searchByAuthor()</code> — using SQL <code>LIKE</code> queries.</li>
  <li><b>Stock Validation:</b> Checks book availability before adding to the cart or placing an order.</li>
  <li><b>Mapping:</b> Converts SQL <code>ResultSet</code> into Java <code>Book</code> objects through the private <code>mapBook()</code> helper.</li>
</ul>

<p>
Every database operation is safely executed using <b>try-with-resources</b> to auto-close connections,  
preventing memory leaks and ensuring clean transaction handling.
</p>

<p><b>Example Workflow:</b></p>
<pre>
BookDao → DB.java → MySQL → books table → returns List&lt;Book&gt;
</pre>

<p>
In the broader architecture, <code>BookDao</code> is used by <b>BookService</b> (from the Service layer) to perform all book-related database operations.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/dao/BookDao.java">
View BookDao.java on GitHub
</a>
</p>

<hr/>

<h3 id="orderdao-class">🧾 7.5 Data Access Layer — <code>OrderDao.java</code></h3>

<p>
The <b>OrderDao.java</b> class manages all database interactions related to <b>orders</b> and <b>order_items</b>.  
It ensures that both tables are properly created, and that each checkout operation records data consistently across both.
</p>

<p><b>Core Responsibilities:</b></p>
<ul>
  <li><b>Table Creation:</b> Creates <code>orders</code> and <code>order_items</code> tables if missing.</li>
  <li><b>Transaction Handling:</b> Uses SQL transactions to insert an order, order items, and update stock atomically — ensuring data consistency.</li>
  <li><b>Order Placement:</b> Inserts a new record in <code>orders</code> (total amount, timestamp, user ID) and multiple records in <code>order_items</code> for each purchased book.</li>
  <li><b>Stock Management:</b> Reduces available stock for each book after an order is successfully placed.</li>
</ul>

<p>
If any step fails (for example, insufficient stock), the transaction is rolled back to avoid partial data updates.  
This ensures complete <b>data integrity</b> and prevents inconsistencies in both <code>orders</code> and <code>books</code> tables.
</p>

<p><b>Example Workflow:</b></p>
<pre>
OrderDao → DB.java → MySQL → (orders, order_items) → commit or rollback
</pre>

<p>
This class is invoked by the <b>CheckoutService</b> class during the checkout process, connecting the Cart logic to actual database transactions.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/dao/OrderDao.java">
View OrderDao.java on GitHub
</a>
</p>

<hr/>

<h3 id="recommendationsdao-class">💡 7.6 Data Access Layer — <code>RecommendationsDao.java</code></h3>

<p>
The <b>RecommendationsDao.java</b> class handles data interactions with the <b>DynamoDB Local</b> instance.  
It serves as the bridge between the Java application and the <b>RecommendedBooks</b> NoSQL table.
</p>

<p><b>Core Responsibilities:</b></p>
<ul>
  <li><b>Table Management:</b> Automatically checks if the <code>RecommendedBooks</code> table exists; if not, creates it with a composite key: <code>userId (HASH)</code> and <code>rank (RANGE)</code>.</li>
  <li><b>Data Seeding:</b> Inserts sample recommendation records for each user, mapping them to existing book titles in MySQL.</li>
  <li><b>Query Execution:</b> Retrieves the top N recommendations for a specific user using a DynamoDB <code>QueryRequest</code>.</li>
  <li><b>Mapping:</b> Converts raw DynamoDB items into Java <code>Recommendation</code> objects.</li>
</ul>

<p>
The DAO uses the <b>Dynamo.java</b> configuration class to connect to the DynamoDB Local instance running on <code>localhost:8000</code>.  
It demonstrates how a hybrid Java application can handle both relational and non-relational data simultaneously.
</p>

<p><b>Example Workflow:</b></p>
<pre>
RecommendationsDao → Dynamo.java → DynamoDB Local → RecommendedBooks table → returns List&lt;Recommendation&gt;
</pre>

<p>
This class is used by the <b>RecommendationsService</b> class to fetch and display book suggestions for users based on their ID.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/dao/RecommendationsDao.java">
View RecommendationsDao.java on GitHub
</a>
</p>
<hr/>

<h3 id="book-model">📗 7.7 Model Layer — <code>Book.java</code></h3>

<p>
The <b>Book.java</b> class represents the core entity of the Online Bookstore application — the <b>Book</b> object.  
It models the attributes and behavior of each book record stored in the MySQL database.
</p>

<p><b>Core Attributes:</b></p>
<ul>
  <li><b>id (long):</b> Unique identifier (Primary Key).</li>
  <li><b>title (String):</b> Name of the book.</li>
  <li><b>author (String):</b> Author of the book.</li>
  <li><b>isbn (String):</b> Standard ISBN code for book identification.</li>
  <li><b>price (BigDecimal):</b> Price of the book with two decimal precision.</li>
  <li><b>stock (int):</b> Available stock count in the inventory.</li>
</ul>

<p>
This class acts as a <b>Plain Old Java Object (POJO)</b> with standard <code>getter</code> and <code>setter</code> methods for each field,  
allowing easy access and modification from other layers like DAO and Service.
</p>

<p><b>Special Implementations:</b></p>
<ul>
  <li><code>equals()</code> and <code>hashCode()</code> methods are overridden to compare books based on their <b>id</b>.  
      This ensures that the same book object can be compared consistently in structures like <code>HashMap</code> or <code>Set</code>.</li>
  <li>Used extensively across the application in components such as <code>BookDao</code>, <code>Cart</code>, and <code>BrowsingHistory</code>.</li>
</ul>

<p>
The <b>Book</b> model is the foundation of multiple workflows — including search, checkout, recommendations, and browsing history tracking.  
It represents the real-world object that the entire system revolves around.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/model/Book.java">
View Book.java on GitHub
</a>
</p>

<hr/>

<h3 id="browsinghistory-model">🕮 7.8 Model Layer — <code>BrowsingHistory.java</code></h3>

<p>
The <b>BrowsingHistory.java</b> class maintains a short-term record of books viewed by the user during the session.  
It is implemented using a <b>LinkedList</b> to efficiently manage the insertion and removal of recently viewed books.
</p>

<p><b>Core Responsibilities:</b></p>
<ul>
  <li>Stores up to the <b>last 5 books</b> viewed by the user.</li>
  <li>Automatically removes duplicates to avoid repetition in the history.</li>
  <li>Ensures the newest viewed book appears at the top of the list.</li>
  <li>Provides methods like <code>add()</code>, <code>getHistory()</code>, <code>isEmpty()</code>, and <code>clear()</code>.</li>
</ul>

<p>
Internally, the class uses:
</p>
<ul>
  <li><b>LinkedList&lt;Book&gt;</b> — to maintain the order of viewing and enable quick insertion/removal.</li>
  <li><b>MAX_SIZE = 5</b> — to restrict history length to 5 entries for simplicity and performance.</li>
</ul>

<p>
Whenever a book is viewed (e.g., in the search results section of <code>App.java</code>),  
that book is passed to <code>browsingHistory.add(book)</code> — automatically updating the recent view list.
</p>

<p><b>Example Behavior:</b></p>
<pre>
Viewed: Clean Code → Design Patterns → Effective Java → Clean Code (again)
Final History: Clean Code, Effective Java, Design Patterns
</pre>

<p>
This class helps simulate a personalized experience by tracking user activity locally —  
a lightweight equivalent of a "Recently Viewed" feature seen in modern e-commerce platforms.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/model/BrowsingHistory.java">
View BrowsingHistory.java on GitHub
</a>
</p>

<hr/>

<h3 id="cart-model">🛒 7.9 Model Layer — <code>Cart.java</code></h3>

<p>
The <b>Cart.java</b> class represents the user’s temporary shopping cart within the application.  
It is implemented using a <b>HashMap&lt;Book, Integer&gt;</b>, where each key is a <code>Book</code> object, and the value represents the quantity.
</p>

<p><b>Core Responsibilities:</b></p>
<ul>
  <li><b>Add Books:</b> Adds a book and its quantity to the cart (using <code>addBook()</code>).</li>
  <li><b>Remove Books:</b> Removes a book from the cart (<code>removeBook()</code>).</li>
  <li><b>View Cart:</b> Returns an unmodifiable view of the cart items (<code>getItems()</code>).</li>
  <li><b>Calculate Total:</b> Multiplies each book’s price by quantity and sums up the total cost (<code>calculateTotal()</code>).</li>
  <li><b>Utility Methods:</b> <code>isEmpty()</code> and <code>clear()</code> help manage cart state efficiently.</li>
</ul>

<p>
The class uses <b>Collections.unmodifiableMap()</b> to ensure that external code cannot modify the cart directly,  
maintaining proper encapsulation and data safety.
</p>

<p><b>Example Workflow:</b></p>
<pre>
cart.addBook(book1, 2)
cart.addBook(book2, 1)
→ Total = (book1.price * 2) + (book2.price * 1)
</pre>

<p>
During checkout, the <b>CheckoutService</b> and <b>OrderDao</b> classes use this cart data  
to create database entries for each order and update stock quantities.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/model/Cart.java">
View Cart.java on GitHub
</a>
</p>
<hr/>

<h3 id="recommendation-model">💡 7.10 Model Layer — <code>Recommendation.java</code></h3>

<p>
The <b>Recommendation.java</b> class represents the model for <b>personalized book recommendations</b> stored in <b>AWS DynamoDB</b>.  
It maps directly to the records in the <code>RecommendedBooks</code> table, which is a NoSQL structure designed for fast and flexible retrieval of user-specific data.
</p>

<p><b>Core Attributes:</b></p>
<ul>
  <li><b>userId (String):</b> The partition key identifying the user for whom recommendations are stored.</li>
  <li><b>rank (int):</b> The sort key that determines the order (priority) of recommended books.</li>
  <li><b>bookId (long):</b> Reference ID linking the recommendation to a specific book in the MySQL <code>books</code> table.</li>
  <li><b>title (String):</b> The title of the recommended book.</li>
  <li><b>author (String):</b> The author of the recommended book.</li>
</ul>

<p>
This class includes a default constructor (for DynamoDB SDK compatibility) and a parameterized constructor for easy object creation.  
All standard <code>getter</code> and <code>setter</code> methods are implemented for data encapsulation.
</p>

<p><b>Key Use Cases:</b></p>
<ul>
  <li>Used by the <code>RecommendationsDao</code> class to store and retrieve recommendation records from DynamoDB.</li>
  <li>Serves as the data model for the <code>RecommendationsService</code> class to display top-N book suggestions to users.</li>
  <li>Helps bridge the NoSQL data (user preferences) with SQL data (actual book details).</li>
</ul>

<p>
This model showcases how hybrid architectures allow seamless integration between SQL and NoSQL components within the same Java application.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/model/Recommendation.java">
View Recommendation.java on GitHub
</a>
</p>

<hr/>

<h3 id="user-model">👤 7.11 Model Layer — <code>User.java</code></h3>

<p>
The <b>User.java</b> class defines the structure for user information within the Online Bookstore system.  
Although the current console-based version uses a default user, this model is designed to support future extensions such as user registration, login, and personalized order history.
</p>

<p><b>Core Attributes:</b></p>
<ul>
  <li><b>id (long):</b> Unique identifier for each user.</li>
  <li><b>username (String):</b> The user’s display or login name.</li>
  <li><b>email (String):</b> Contact email for the user.</li>
  <li><b>passwordHash (String):</b> Encrypted password for secure authentication.</li>
</ul>

<p>
This class provides <code>getter</code> and <code>setter</code> methods for all attributes, maintaining proper data encapsulation.  
It represents a simple yet extensible structure that can easily integrate with authentication modules or external APIs later.
</p>

<p><b>Key Use Cases:</b></p>
<ul>
  <li>Acts as a data carrier between the <b>database</b> and <b>application logic</b> layers.</li>
  <li>Linked with the <code>orders</code> table (via <code>user_id</code>) to associate purchases with a specific customer.</li>
  <li>Future-ready for implementation of features like <b>login</b>, <b>signup</b>, and <b>profile management</b>.</li>
</ul>

<p>
Currently, it functions as a placeholder entity, representing how user data would be structured in a scalable version of the bookstore application.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/model/User.java">
View User.java on GitHub
</a>
</p>
<hr/>

<h3 id="bookservice-class">📘 7.12 Service Layer — <code>BookService.java</code></h3>

<p>
The <b>BookService.java</b> class serves as the <b>business logic layer</b> between the user interface (<code>App.java</code>) and the data access layer (<code>BookDao.java</code>).  
It ensures that all book-related operations follow clean, modular, and consistent logic before reaching the database.
</p>

<p><b>Core Responsibilities:</b></p>
<ul>
  <li><b>Initialization:</b> Automatically creates the <code>books</code> table and seeds it with default data if it’s empty (handled via <code>dao.seedIfEmpty()</code>).</li>
  <li><b>Book Search:</b> Provides methods <code>searchByTitle()</code> and <code>searchByAuthor()</code> to find books using user input.</li>
  <li><b>Abstraction:</b> Hides SQL and database logic from the main application, ensuring that <code>App.java</code> only interacts through clean method calls.</li>
</ul>

<p>
In essence, <b>BookService</b> acts as a controller for all book-related logic,  
fetching data through the <code>BookDao</code> while maintaining a clean separation between UI and database layers.
</p>

<p><b>Example Workflow:</b></p>
<pre>
App.java → BookService → BookDao → MySQL Database (books table)
</pre>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/service/BookService.java">
View BookService.java on GitHub
</a>
</p>

<hr/>

<h3 id="checkoutservice-class">🧾 7.13 Service Layer — <code>CheckoutService.java</code></h3>

<p>
The <b>CheckoutService.java</b> class manages the <b>checkout process</b> — connecting the user’s <code>Cart</code> to the <code>OrderDao</code> for database persistence.  
It ensures that the checkout logic is performed safely, atomically, and in the correct sequence.
</p>

<p><b>Core Responsibilities:</b></p>
<ul>
  <li><b>Initialization:</b> Creates the necessary tables (<code>orders</code> and <code>order_items</code>) via the <code>OrderDao</code>.</li>
  <li><b>Checkout Operation:</b> Validates that the cart is not empty before proceeding with order creation.</li>
  <li><b>Order Creation:</b> Calculates total price, delegates data insertion to <code>OrderDao</code>, and clears the cart upon success.</li>
  <li><b>Error Handling:</b> Prevents incomplete or empty checkouts with proper validation and exceptions.</li>
</ul>

<p>
This service layer ensures that business logic like total calculation, order management, and cart reset happen correctly  
before committing data to the database.
</p>

<p><b>Example Workflow:</b></p>
<pre>
App.java → CheckoutService → OrderDao → MySQL Database (orders, order_items)
</pre>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/service/CheckoutService.java">
View CheckoutService.java on GitHub
</a>
</p>

<hr/>

<h3 id="recommendationsservice-class">💡 7.14 Service Layer — <code>RecommendationsService.java</code></h3>

<p>
The <b>RecommendationsService.java</b> class acts as the middle layer between the main application and the <b>DynamoDB</b> database.  
It handles the retrieval and management of user-specific book recommendations.
</p>

<p><b>Core Responsibilities:</b></p>
<ul>
  <li><b>Table Management:</b> Ensures the <code>RecommendedBooks</code> table exists in DynamoDB by invoking <code>dao.createTableIfNotExists()</code>.</li>
  <li><b>Data Seeding:</b> Seeds sample recommendation data for a user through <code>seedUser(userId)</code> (used for demo setup).</li>
  <li><b>Top Recommendations:</b> Fetches the top 5 recommendations for a user using <code>dao.topN()</code> method.</li>
</ul>

<p>
The class encapsulates the logic required to interact with NoSQL data sources,  
demonstrating how the application integrates structured (MySQL) and unstructured (DynamoDB) data models seamlessly.
</p>

<p><b>Example Workflow:</b></p>
<pre>
App.java → RecommendationsService → RecommendationsDao → DynamoDB Local (RecommendedBooks table)
</pre>

<p>
By keeping this logic separate from the main application, <b>RecommendationsService</b> maintains a modular, testable structure  
that supports both scalability and reusability.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/java/com/example/bookstore/service/RecommendationsService.java">
View RecommendationsService.java on GitHub
</a>
</p>


<hr/>

<h3 id="resources-folder">📦 7.15 Resources Folder — <code>recommendations.json</code></h3>

<p>
The <b>resources</b> directory contains runtime configuration and data files required by the application during execution.  
In this project, it mainly holds a JSON file named <code>recommendations.json</code>,  
which acts as sample data for initializing the <b>DynamoDB Local</b> instance.
</p>

<p>
📄 <b>File:</b> <code>src/main/resources/recommendations.json</code>
</p>

<p><b>Purpose:</b></p>
<ul>
  <li>Provides a lightweight local dataset for personalized book recommendations.</li>
  <li>Used during application initialization to seed DynamoDB with demo data for users like “Arham” and “Guest”.</li>
  <li>Demonstrates how the <b>App.java</b> and <b>RecommendationsService</b> classes can read structured data  
      from external files instead of hardcoding it inside Java code.</li>
</ul>

<p><b>Example JSON Structure:</b></p>
<pre>
{
  "RecommendedBooks": [
    {
      "PutRequest": {
        "Item": {
          "user": { "S": "Arham" },
          "recommendations": {
            "L": [
              { "S": "Effective Java" },
              { "S": "Clean Architecture" },
              { "S": "Refactoring" },
              { "S": "Domain-Driven Design" },
              { "S": "Head First Design Patterns" }
            ]
          }
        }
      }
    }
  ]
}
</pre>

<p>
This file helps simulate a real-world <b>recommendation system</b> without connecting to the cloud version of DynamoDB.  
It makes the local setup simple, quick, and functional for demo or training environments.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/main/resources/recommendations.json">
View recommendations.json on GitHub
</a>
</p>

---

<h4>🧠 How it fits into the system</h4>
<p>
When the <code>App.java</code> starts, it initializes the <b>RecommendationsService</b>,  
which uses the <code>recommendations.json</code> file to seed data into the local DynamoDB instance.  
This allows the system to instantly display book suggestions without requiring any user data entry.
</p>

<p><b>Workflow:</b></p>
<pre>
resources/recommendations.json 
   ⬇ 
RecommendationsDao.java 
   ⬇ 
DynamoDB Local 
   ⬇ 
App.java → Displays recommendations for current user
</pre>

<hr/>

<h2 id="test-layer">🧪 8. TEST LAYER</h2>

<p>
The <b>Test Layer</b> ensures the reliability and correctness of the Online Bookstore application.  
All test cases are implemented using <b>JUnit 5 (Jupiter)</b> under the directory:
</p>

<pre><code>src/test/java/com/example/bookstore/test/</code></pre>

<p>
This layer verifies that every major component — from services to models — behaves as expected.  
The tests are structured to reflect real user operations such as searching for books, adding them to a cart, and completing checkout.
</p>

---

<h3 id="bookservice-test">📗 8.1 <code>BookServiceTest.java</code></h3>

<p>
The <b>BookServiceTest</b> class validates the core functionality of the <b>BookService</b> — ensuring book search features work correctly and that seeding and initialization occur as intended.
</p>

<p><b>Key Responsibilities:</b></p>
<ul>
  <li>Verifies that the database tables are created and seeded properly using <code>bookService.init()</code>.</li>
  <li>Tests title-based search through <code>searchByTitle()</code>.</li>
  <li>Tests author-based search through <code>searchByAuthor()</code>.</li>
  <li>Confirms that results contain expected book entries (“Clean Code” and “Design Patterns”).</li>
</ul>

<p><b>Example Test Flow:</b></p>
<pre>
@BeforeEach → Initializes BookService and database tables
@Test(searchByTitle) → Verifies “Clean Code” exists
@Test(searchByAuthor) → Verifies “Erich Gamma” exists
</pre>

<p>
Each test uses assertions like <code>assertTrue()</code>, <code>assertFalse()</code>, and <code>assertNotNull()</code>  
to ensure that data retrieved from MySQL matches the expected content.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/test/java/com/example/bookstore/test/BookServiceTest.java">
View BookServiceTest.java on GitHub
</a>
</p>

---

<h3 id="cart-test">🛒 8.2 <code>CartTest.java</code></h3>

<p>
The <b>CartTest</b> class validates the functionality of the <b>Cart</b> model —  
ensuring correct behavior for adding, removing, and totaling items.
</p>

<p><b>Core Objectives:</b></p>
<ul>
  <li>Tests the <code>addBook()</code> method to verify books and quantities are stored correctly.</li>
  <li>Ensures the <code>calculateTotal()</code> method correctly computes total cost using <code>BigDecimal</code>.</li>
  <li>Verifies the <code>removeBook()</code> method successfully removes items and empties the cart.</li>
</ul>

<p><b>Example Test Flow:</b></p>
<pre>
@BeforeEach → Initializes an empty Cart and a sample Book
@Test(addAndCalculateTotal) → Adds book (qty 2) and verifies total = 200.00
@Test(removeBook) → Removes book and verifies cart is empty
</pre>

<p>
This test ensures that the <b>Cart</b> class is functioning properly before being used in the main checkout workflow.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/test/java/com/example/bookstore/test/CartTest.java">
View CartTest.java on GitHub
</a>
</p>

---

<h3 id="checkoutservice-test">🧾 8.3 <code>CheckoutServiceTest.java</code></h3>

<p>
The <b>CheckoutServiceTest</b> validates the entire <b>checkout process</b> —  
from adding a temporary book to creating an order and verifying database persistence.
</p>

<p><b>Core Objectives:</b></p>
<ul>
  <li><b>Database Setup:</b> Ensures the <code>books</code>, <code>orders</code>, and <code>order_items</code> tables exist.</li>
  <li><b>Data Insertion:</b> Inserts a temporary book into the database before each test.</li>
  <li><b>Order Creation:</b> Builds a <code>Cart</code> with a known book and runs the checkout flow.</li>
  <li><b>Cleanup:</b> Deletes the temporary book entry after each test to maintain data integrity.</li>
</ul>

<p><b>Lifecycle Annotations Used:</b></p>
<ul>
  <li><code>@BeforeAll</code> → Initializes schema using <code>BookService</code> and <code>CheckoutService</code>.</li>
  <li><code>@BeforeEach</code> → Inserts temporary book before each test run.</li>
  <li><code>@AfterEach</code> → Cleans up the book record after test completion.</li>
  <li><code>@TestMethodOrder</code> → Ensures tests run in a controlled order.</li>
</ul>

<p><b>Example Test Flow:</b></p>
<pre>
@BeforeAll → Setup schema (books + orders)
@BeforeEach → Insert temp book
@Test → Perform checkout
@AfterEach → Cleanup temp data
</pre>

<p>
Assertions like <code>assertTrue()</code> and <code>assertNotNull()</code> ensure that  
the order creation process executes correctly and that an order ID is successfully returned from MySQL.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/test/java/com/example/bookstore/test/CheckoutServiceTest.java">
View CheckoutServiceTest.java on GitHub
</a>
</p>

---

<h3 id="testing-summary">✅ 8.4 Summary of Test Layer</h3>

<p>
The Test Layer ensures that all critical components of the application work reliably both independently and together.
</p>

<table border="1" cellpadding="6" cellspacing="0">
  <tr>
    <th>Test Class</th>
    <th>Focus Area</th>
    <th>Validated Layer</th>
  </tr>
  <tr>
    <td><code>BookServiceTest</code></td>
    <td>Book search and initialization</td>
    <td>Service + DAO</td>
  </tr>
  <tr>
    <td><code>CartTest</code></td>
    <td>Add/remove items and total calculation</td>
    <td>Model</td>
  </tr>
  <tr>
    <td><code>CheckoutServiceTest</code></td>
    <td>Order creation and checkout workflow</td>
    <td>Service + DAO + Database</td>
  </tr>
</table>

<p>
Together, these tests provide complete coverage of the <b>Online Bookstore’s</b> critical business processes.  
They guarantee that the code remains stable, accurate, and maintainable through future updates.
</p>

<hr/>

<h3 id="junit-platform-config">⚙️ 8.5 JUnit Platform Configuration — <code>junit-platform.properties</code></h3>

<p>
The <b>junit-platform.properties</b> file configures how the <b>JUnit 5 test engine</b> discovers and executes test cases.  
It provides global settings for test order, naming, and performance reporting.
</p>

<p><b>File Path:</b><br/>
<code>src/test/resources/recommendation/junit-platform.properties</code>
</p>

<p><b>Purpose:</b></p>
<ul>
  <li>Displays meaningful names for test cases in console reports.</li>
  <li>Ensures predictable execution order using <code>@Order</code> annotations.</li>
  <li>Disables parallel execution for database consistency.</li>
  <li>Shows execution time for each test to help with performance analysis.</li>
</ul>

<p><b>Example Configuration:</b></p>
<pre><code>
# JUnit 5 Platform Configuration
junit.jupiter.displayname.generator.default = org.junit.jupiter.api.DisplayNameGenerator$Simple
junit.jupiter.execution.time.enabled = true
junit.jupiter.execution.parallel.enabled = false
junit.jupiter.testmethod.order.default = org.junit.jupiter.api.MethodOrderer$OrderAnnotation
</code></pre>

<p>
This ensures that all test results are displayed in a clear and consistent way,  
making debugging and CI/CD integration easier.  
It also reflects a clean, production-ready setup using only <b>JUnit 5</b> —  
without any external frameworks like Cucumber.
</p>

<p>
🔗 <b>GitHub Source:</b><br/>
<a href="https://github.com/Arham-Mian/Online_Book_Store/blob/main/src/test/resources/recommendation/junit-platform.properties">
View junit-platform.properties on GitHub
</a>
</p>
