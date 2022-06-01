package com.example.week3day4.advice;

import com.example.week3day4.dto.Response;
import com.example.week3day4.exception.InvalidIDException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceHandler {

//    @ExceptionHandler(value = ExceptionName.class)
//    public ResponseEntity handleExceptionName(ExceptionName exceptionName){
//        String err_msg=exceptionName.getMessage();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(err_msg,400));
//    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(message,400));
    }
        @ExceptionHandler(value = InvalidIDException.class)
    public ResponseEntity handleExceptionName(InvalidIDException invalidIDException){
        String err_msg=invalidIDException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(err_msg,400));
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Server Error!",500));
    }
}
