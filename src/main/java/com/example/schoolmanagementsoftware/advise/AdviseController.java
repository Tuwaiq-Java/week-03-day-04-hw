package com.example.schoolmanagementsoftware.advise;


import com.example.schoolmanagementsoftware.DTO.API;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.schoolmanagementsoftware.service.ClassService;

import java.util.logging.Logger;

@RestControllerAdvice
public class ControllerAdviseHandler {

    Logger logger = (Logger) LoggerFactory.getLogger(ClassService.class);


    @ExceptionHandler(value = InvalidIdException.class)
     public ResponseEntity<API> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
     Logger.info (massegge);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
        }}