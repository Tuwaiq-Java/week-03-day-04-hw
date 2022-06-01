package com.example.week3day4ex.advice;

import com.example.week3day4ex.exception.InvalidIdException;
import com.example.week3day4ex.model.API;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleExeption(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(500).body(new API("SERVER ERROR !",500));
    }


    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(400).body(new API(message,400));
    }

}
