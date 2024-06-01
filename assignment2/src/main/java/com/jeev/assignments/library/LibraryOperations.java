package com.jeev.assignments.library;

import com.jeev.assignments.books.Book;
import com.jeev.assignments.members.Member;

public interface LibraryOperations {
    boolean issueBook(Book book, Member member) throws BookNotAvailableException, MaxBookLimitReachedException;
    boolean returnBook(Book book, Member member) throws BookNotIssuedException;
}
