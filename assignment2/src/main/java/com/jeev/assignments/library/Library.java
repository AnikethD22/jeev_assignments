package com.jeev.assignments.library;

import com.jeev.assignments.books.Book;
import com.jeev.assignments.members.Member;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryOperations {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    /**
     * Issues a book to a member.
     *
     * @param book   the book to be issued
     * @param member the member to whom the book is to be issued
     * @return true if the book is successfully issued, false otherwise
     * @throws BookNotAvailableException if the book is not available in the library or already issued
     * @throws MaxBookLimitReachedException if the member has reached the maximum limit of issued books
     */
    @Override
    public boolean issueBook(Book book, Member member) throws BookNotAvailableException, MaxBookLimitReachedException {
        if (!books.contains(book)) {
            throw new BookNotAvailableException("The book is not available in the library.");
        }
        if (book.isIssued()) {
            throw new BookNotAvailableException("The book is already issued.");
        }
        if (member.getCurrentIssuedBooks().size() >= member.getMaxBooksIssued()) {
            throw new MaxBookLimitReachedException("The Member has reached the maximum books limit.");
        }

        book.setIssued(true);
        member.issueBook(book);
        return true;
    }

    /**
     * Returns a book from a member.
     *
     * @param book   the book to be returned
     * @param member the member returning the book
     * @return true if the book is successfully returned, false otherwise
     * @throws BookNotIssuedException if the member does not have the book
     */
    @Override
    public boolean returnBook(Book book, Member member) throws BookNotIssuedException {
        if (!member.hasBook(book)) {
            throw new BookNotIssuedException("The member does not have this book.");
        }
        book.setIssued(false);
        member.removeBook(book);
        return true;
    }

    /**
     * Gets the list of books in the library.
     *
     * @return the list of books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Sets the list of books in the library.
     *
     * @param books the list of books to set
     */
    public void addBooks(List<Book> books) {
        if (books == null)
            System.out.println("No books to add");
        else
            this.books.addAll(books);
    }

    /**
     * Gets the list of members in the library.
     *
     * @return the list of members
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Sets the list of members in the library.
     *
     * @param members the list of members to set
     */
    public void addMembers(List<Member> members) {
        this.members.addAll(members);
    }

    /**
     * Adds a book to the library.
     *
     * @param book the book to be added
     * @return true if the book is successfully added, false otherwise
     */
    public boolean addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            return true;
        }
        return false;
    }

    /**
     * Removes a book from the library.
     *
     * @param book the book to be removed
     * @return true if the book is successfully removed, false otherwise
     */
    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    /**
     * Adds a member to the library.
     *
     * @param member the member to be added
     * @return true if the member is successfully added, false otherwise
     */
    public boolean addMember(Member member) {
        if (!members.contains(member)) {
            members.add(member);
            return true;
        }
        return false;
    }

    /**
     * Removes a member from the library.
     *
     * @param member the member to be removed
     * @return true if the member is successfully removed, false otherwise
     */
    public boolean removeMember(Member member) {
        return members.remove(member);
    }
    

    /**
     * Gets a member by their ID.
     *
     * @param id the ID of the member
     * @return the member with the specified ID, or null if not found
     */
    public Member getMemberByID(int id) {
        for (Member member : members) {
            if (member.getMemberID() == id) {
                return member;
            }
        }
        return null;
    }

    /**
     * Gets a book by its ID.
     *
     * @param id the ID of the book
     * @return the book with the specified ID, or null if not found
     */
    public Book getBookByID(int id) {
        for (Book book : books) {
            if (book.getBookID() == id) {
                return book;
            }
        }
        return null;
    }

}