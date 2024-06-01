package com.jeev.assignments.books;

/**
 * The `Book` class represents a book with an ID, title, author, and issued status.
 */
public class Book {
    // Private member variables to store the book's ID, title, author, and issued status
    private int bookID;
    private String title;
    private String author;
    private boolean isIssued;
    // This is to ensure the book id is unique
    private static int bookCounter = 0;

    /**
     * Constructor to initialize a new `Book` object with the given parameters.
     *
     * @param bookID   The unique identifier for the book.
     * @param title    The title of the book.
     * @param author   The author of the book.
     * @param isIssued The issued status of the book (true if issued, false otherwise).
     */
    public Book(String title, String author) {
        this.bookID = bookCounter++;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        
    }

    // Getter method for bookID
    public int getBookID() {
        return bookID;
    }

    // Setter method for bookID with validation
    public void setBookID(int bookID) {
        if (bookID <= 0) {
            throw new IllegalArgumentException("Book ID must be a positive integer.");
        }
        this.bookID = bookID;
    }

    // Getter method for title
    public String getTitle() {
        return title;
    }

    // Setter method for title with validation
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    // Getter method for author
    public String getAuthor() {
        return author;
    }

    // Setter method for author with validation
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.author = author;
    }

    // Getter method for isIssued
    public boolean isIssued() {
        return isIssued;
    }

    // Setter method for isIssued with validation
    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    // Method to help print the Member info
    @Override
    public String toString() {
        return "Book{" +
                "ID='" + bookID + '\'' +
                ",title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", issued=" + isIssued +
                '}';
    }
}