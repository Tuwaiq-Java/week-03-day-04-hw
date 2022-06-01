package com.example.w3d4exer.advice;

import com.example.w3d4exer.DTO.api;
import com.example.w3d4exer.exeptions.InvalidId;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class advicecontroller {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<api> handleException(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(500).body(new api("SERVER ERROR !",500));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<api> handleException2(DataIntegrityViolationException dataintvioexp){
        String message=dataintvioexp.getCause().getMessage();
        return ResponseEntity.status(400).body(new api(message,400));
}
    @ExceptionHandler(value = InvalidId.class)
    public ResponseEntity<api> handleDataIntegrity(InvalidId invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new api(message,400));
    }

}
