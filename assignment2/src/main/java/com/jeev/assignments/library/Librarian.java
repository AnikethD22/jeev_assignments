package com.jeev.assignments.library;

import com.jeev.assignments.books.Book;
import com.jeev.assignments.members.Member;

public class Librarian extends Member {

    private Library library;
    
    // Constructor
    public Librarian(String name) {
        // Setting 10 as the max books limit for Librarian
        super(name); // Call the constructor of the Member class
    }

    // Getter for library
    public Library getLibrary() {
        return library;
    }

    // Setter for library with validation
    public void setLibrary(Library library) {
        if (library == null) {
            throw new IllegalArgumentException("Library cannot be null");
        }
        this.library = library;
    }
    
    // Additional responsibilities with validation
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (library == null) {
            throw new IllegalStateException("Library is not set");
        }
        library.addBook(book);
    }

    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (library == null) {
            throw new IllegalStateException("Library is not set");
        }
        library.removeBook(book);
    }

    
    // public void issueBook(Book book, Member member) {
    //     if (member == null){
    //         throw new IllegalArgumentException("Invalid Member");
    //     }
    //     if (member.getCurrentIssuedBooks().size() >= member.getMaxBooksIssued()) {
    //         throw new IllegalStateException("Cannot issue more books. Maximum limit reached.");
    //     }
        
    //     if (book == null || library.getBookByID(book.getBookID()).isIssued()){
    //         throw new IllegalArgumentException("Book is not available in the Library");
    //     }

    //     library.getBookByID(book.getBookID()).setIssued(true);
    //     member.getCurrentIssuedBooks().add(book);
        
    // }

    // public void removeBook(Book book, Member member) {
    //     if (member == null){
    //         throw new IllegalArgumentException("Invalid Member");
    //     }
    //     if (book == null || !library.getBookByID(book.getBookID()).isIssued()){
    //         throw new IllegalArgumentException("Invalid book to return");
    //     }

    //     library.getBookByID(book.getBookID()).setIssued(false);
    //     member.getCurrentIssuedBooks().remove(book);
    // }
}