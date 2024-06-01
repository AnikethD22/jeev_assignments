package com.jeev.assignments.library;

public class MaxBookLimitReachedException extends Exception {
    public MaxBookLimitReachedException(String message) {
        super(message);
    }
}