package com.example.springhandel.exceptions;

public class InvalidException extends RuntimeException {
    public InvalidException(String message) {
        super(message);
    }
}
