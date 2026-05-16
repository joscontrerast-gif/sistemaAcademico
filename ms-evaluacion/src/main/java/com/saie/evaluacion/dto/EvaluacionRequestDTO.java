package com.saie.evaluacion.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EvaluacionRequestDTO {

    private String nombre;

    private Long profesorId;

    private Long cursoId;

    private LocalDate fecha;

    private Double ponderacion;
}