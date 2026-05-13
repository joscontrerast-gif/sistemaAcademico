package com.saie.evaluacion.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evaluaciones")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Long cursoId;

    private LocalDate fecha;

    private Double ponderacion;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getPonderacion() {
        return ponderacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPonderacion(Double ponderacion) {
        this.ponderacion = ponderacion;
    }
}