package com.example.schoolmmanagement.advise;

import com.example.schoolmmanagement.DTO.ApiResponce;
import com.example.schoolmmanagement.exceptions.InvalidIdExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviseHandler {
    Logger logger = LoggerFactory.getLogger(ControllerAdviseHandler.class);
    // Class Exception for ID
    @ExceptionHandler(value = InvalidIdExceptions.class)
    public ResponseEntity<ApiResponce> handleException(InvalidIdExceptions invalid){
        String message = invalid.getMessage();
        logger.info(message);
        return ResponseEntity.status(400).body(new ApiResponce(message,400));
    }
}
