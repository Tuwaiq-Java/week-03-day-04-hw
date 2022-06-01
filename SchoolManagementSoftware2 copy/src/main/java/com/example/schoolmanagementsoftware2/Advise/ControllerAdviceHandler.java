package com.example.schoolmanagementsoftware2.Advise;

import com.example.schoolmanagementsoftware2.Exception.ClassroomNotFoundException;
import com.example.schoolmanagementsoftware2.Exception.InvalidIDException;
import com.example.schoolmanagementsoftware2.Exception.StudentNotFoundException;
import com.example.schoolmanagementsoftware2.Exception.TeacherNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceHandler {


         Logger logger = LoggerFactory.getLogger(ControllerAdviceHandler.class);
        @ExceptionHandler(value = MethodArgumentNotValidException.class)
        public ResponseEntity handleMethodArgument(MethodArgumentNotValidException methodArgumentNVE){
            logger.warn("MethodArgumentNotValidException");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((methodArgumentNVE.getFieldError().getDefaultMessage()));
        }

        @ExceptionHandler(value = DataIntegrityViolationException.class)
        public ResponseEntity handleDataIntegrity(DataIntegrityViolationException dataIntegrityVE){
            logger.warn("DataIntegrityViolationException");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((dataIntegrityVE.getCause().getMessage()));
        }

        @ExceptionHandler(value = InvalidIDException.class)
        public ResponseEntity handleDataIntegrity(InvalidIDException invalidIDE){
            logger.warn("InvalidIDException");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidIDE.getCause().getMessage());
        }

        @ExceptionHandler(value = ClassroomNotFoundException.class)
        public ResponseEntity handleDataIntegrity(ClassroomNotFoundException classNFE){
            logger.warn("ClassroomNotFoundException");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(classNFE.getCause().getMessage());
        }

        @ExceptionHandler(value = TeacherNotFoundException.class)
        public ResponseEntity handleDataIntegrity(TeacherNotFoundException teacherNFE){
            logger.warn("TeacherNotFoundException");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(teacherNFE.getCause().getMessage());
        }

        @ExceptionHandler(value = StudentNotFoundException.class)
        public ResponseEntity handleDataIntegrity(StudentNotFoundException studentNFE){
            logger.warn("StudentNotFoundException");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(studentNFE.getCause().getMessage());
        }

        @ExceptionHandler(value = Exception.class)
        public ResponseEntity handleException(Exception exception) {
            logger.error("Exception");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getCause().getMessage());
        }
}
