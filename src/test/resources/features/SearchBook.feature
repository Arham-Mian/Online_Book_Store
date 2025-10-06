Feature: Search a book by title
  As a user of the bookstore
  I want to search books by title
  So that I can see the author name in results

  Scenario: User searches a book by title
    Given the bookstore has "Clean Code" by "Robert C. Martin" priced 450.00 with stock 10
    When the user searches for title "Clean Code"
    Then the system shows a result with title "Clean Code" and author "Robert C. Martin"
