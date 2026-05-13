package com.saie.evaluacion.dto;

import java.time.LocalDate;

public class EvaluacionDTO {

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