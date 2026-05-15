package com.saie.evaluacion.dto.external;

import java.time.LocalDate;

public class MatriculaDTO {

    private Long id;

    private Long estudianteId;

    private Long cursoId;

    private LocalDate fechaMatricula;

    private String estado;

    public Long getId() {
        return id;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}