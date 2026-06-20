package com.saie.evaluacion.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EvaluacionDTO {

    private Long id;

    private String nombre;

    private Long alumnoId;

    private Long cursoId;

    private LocalDateTime fecha;

    private Double ponderacion;
}