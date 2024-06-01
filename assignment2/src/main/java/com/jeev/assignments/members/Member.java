package com.jeev.assignments.members;

import com.jeev.assignments.books.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a member in the library system.
 */
public class Member {
    // Unique identifier for the member
    private int memberID;
    
    // Name of the member
    private String name;
    
    // Maximum number of books that can be issued to the member by default is 5
    private int maxBooksIssued = 5;
    
    // List of books currently issued to the member
    private List<Book> currentIssuedBooks;


    private static int memberCounter = 0;


    /**
     * Parameterized constructor to initialize a member with given details.
     *
     * @param memberID the unique identifier for the member
     * @param name the name of the member
     * @param maxBooksIssued the maximum number of books that can be issued to the member
     * @param currentIssuedBooks the list of books currently issued to the member
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Member(String name) {
        setMemberID(memberCounter++);
        setName(name);
        setMaxBooksIssued(maxBooksIssued);
        // List will be empty when a new member is created.
        setCurrentIssuedBooks(new ArrayList<Book>());
        
    }

    /**
     * Gets the unique identifier for the member.
     *
     * @return the memberID
     */
    public int getMemberID() {
        return memberID;
    }

    /**
     * Sets the unique identifier for the member.
     *
     * @param memberID the memberID to set
     * @throws IllegalArgumentException if memberID is negative
     */
    public void setMemberID(int memberID) {
        if (memberID < 0) {
            throw new IllegalArgumentException("Member ID cannot be negative.");
        }
        this.memberID = memberID;
    }

    /**
     * Gets the name of the member.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the member.
     *
     * @param name the name to set
     * @throws IllegalArgumentException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    /**
     * Gets the maximum number of books that can be issued to the member.
     *
     * @return the maxBooksIssued
     */
    public int getMaxBooksIssued() {
        return maxBooksIssued;
    }

    /**
     * Sets the maximum number of books that can be issued to the member.
     *
     * @param maxBooksIssued the maxBooksIssued to set
     * @throws IllegalArgumentException if maxBooksIssued is negative
     */
    public void setMaxBooksIssued(int maxBooksIssued) {
        if (maxBooksIssued < 1) {
            throw new IllegalArgumentException("Maximum number of books issued cannot be less than 1.");
        }
        this.maxBooksIssued = maxBooksIssued;
    }

    /**
     * Gets the list of books currently issued to the member.
     *
     * @return the currentIssuedBooks
     */
    public List<Book> getCurrentIssuedBooks() {
        return currentIssuedBooks;
    }

    /**
     * Sets the list of books currently issued to the member.
     *
     * @param currentIssuedBooks the currentIssuedBooks to set
     * @throws IllegalArgumentException if currentIssuedBooks is null
     */
    public void setCurrentIssuedBooks(List<Book> currentIssuedBooks) {
        if (currentIssuedBooks == null) {
            throw new IllegalArgumentException("Current issued books list cannot be null.");
        }
        this.currentIssuedBooks = currentIssuedBooks;
    }
        
    public boolean hasBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        return currentIssuedBooks.contains(book);
    }
    
    public void issueBook(Book book) {
        if (currentIssuedBooks.size() >= maxBooksIssued) {
            throw new IllegalStateException("Cannot issue more books. Maximum limit reached.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        currentIssuedBooks.add(book);
    }

    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (!currentIssuedBooks.remove(book)) {
            throw new IllegalStateException("Book not found in the issued list.");
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberID +        
                ",name='" + name + '\'' +
                ", currentIssuedBooks=" + currentIssuedBooks +
                '}';
    }
}