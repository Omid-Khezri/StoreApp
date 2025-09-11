package com.storeapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)  // <- sagt Spring, welche Fehler behandelt werden
    public ResponseEntity<String> handle(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
