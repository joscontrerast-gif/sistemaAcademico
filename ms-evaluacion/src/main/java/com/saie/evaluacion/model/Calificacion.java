package com.saie.evaluacion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long evaluacionId;

    private Long estudianteId;

    private Double nota;

    private String observacion;

    public Long getId() {
        return id;
    }

    public Long getEvaluacionId() {
        return evaluacionId;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public Double getNota() {
        return nota;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEvaluacionId(Long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}