package com.springbootpgrest.talley;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(404).body(Map.of("error", ex.getMessage()));
    }
}
