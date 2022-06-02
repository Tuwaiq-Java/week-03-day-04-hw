package com.example.demo.Exception;

public class UserIsAdminException  extends RuntimeException{
    public UserIsAdminException(String message) {
        super(message);
    }
}
