package com.example.school.excptiones;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException(String massage){

        super(massage);
    }

}

