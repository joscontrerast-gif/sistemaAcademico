package com.saie.evaluacion.model;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;

@Entity
@Table(name = "evaluaciones")
@Data
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PrePersist
    public void prePersist() {
        this.fecha = LocalDateTime.now();
    }

    private String nombre;
    private Long alumnoId;
    private Long cursoId;
    private LocalDateTime fecha;
    private Double ponderacion;
}