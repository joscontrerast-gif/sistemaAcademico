package com.saie.matricula.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ResourceNotFoundException.class)

    public ResponseEntity<?> manejarNotFound(
            ResourceNotFoundException ex){

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "mensaje",
                ex.getMessage());

        response.put(
                "status",
                404);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}