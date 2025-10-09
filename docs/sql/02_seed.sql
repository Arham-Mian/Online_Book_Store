USE bookstore_fresh;

INSERT INTO books(title,author,isbn,price,stock) VALUES
('Clean Code','Robert C. Martin','9780132350884',450.00,10),
('Design Patterns','Erich Gamma','9780201633610',550.00,8),
('Harry Potter and the Philosopher''s Stone','J.K. Rowling','9780747532699',400.00,7)
ON DUPLICATE KEY UPDATE stock=VALUES(stock);
