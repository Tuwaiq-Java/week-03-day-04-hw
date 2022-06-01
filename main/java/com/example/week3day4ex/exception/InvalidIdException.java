package com.example.week3day4ex.exception;

public class InvalidIdException extends RuntimeException {

    public InvalidIdException(String msg){
        super(msg);
    }
}
