package com.example.w3d04exer.advice;


import com.example.w3d04exer.DTO.Api;
import com.example.w3d04exer.exceptions.InvalidIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
// here we handle all the exceptions
public class ControllerAdviceHandler {


    Logger logger = LoggerFactory.getLogger(ControllerAdviceHandler.class);


    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<Api> handleIdException(InvalidIdException invalidIdException){
        logger.error("id issue");
        logger.trace("");
        String message = invalidIdException.getMessage();

        return ResponseEntity.status(400).body(new Api(message,400));

}




























    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api> handleException(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api("SERVER ERROR !",500));
    }







}
