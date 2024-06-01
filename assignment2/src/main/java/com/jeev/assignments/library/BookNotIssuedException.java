package com.jeev.assignments.library;

public class BookNotIssuedException extends Exception {
    public BookNotIssuedException(String message) {
        super(message);
    }
}