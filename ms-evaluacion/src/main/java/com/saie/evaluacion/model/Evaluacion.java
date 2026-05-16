package com.saie.evaluacion.model;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "evaluaciones")
@Data
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Long profesorId;

    private Long cursoId;

    private LocalDate fecha;

    private Double ponderacion;
}