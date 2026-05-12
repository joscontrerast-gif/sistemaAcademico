package com.saie.usuarios.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String mensaje;

    private int status;

    private LocalDateTime fecha;
}