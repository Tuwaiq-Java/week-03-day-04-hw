package com.example.useradviceexample0304.adviceHandler;

import com.example.useradviceexample0304.DTO.API;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAdviceHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity dataIntegrityExceptionHandling(DataIntegrityViolationException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(e.getRootCause().getMessage(), 400));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity dataIntegrityExceptionHandling(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(e.getMessage(), 400));
    }


}
