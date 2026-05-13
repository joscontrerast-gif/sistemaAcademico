package com.saie.evaluacion.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ResourceNotFoundException.class)

    public ResponseEntity<?> manejarNotFound(
            ResourceNotFoundException ex){

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now());

        response.put(
                "status",
                404);

        response.put(
                "error",
                "NOT_FOUND");

        response.put(
                "mensaje",
                ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}