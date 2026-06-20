package com.saie.asistencia.dto;

import java.time.LocalDate;

public class AsistenciaDTO {

    private Long id;
    private Long alumnoId;
    private Long cursoId;
    private String estado;
    private LocalDate fecha;

    // Constructor vacío (OBLIGATORIO)
    public AsistenciaDTO() {
    }

    // Constructor completo (opcional pero recomendado)
    public AsistenciaDTO(Long id, Long alumnoId, Long cursoId, String estado, LocalDate fecha) {
        this.id = id;
        this.alumnoId = alumnoId;
        this.cursoId = cursoId;
        this.estado = estado;
        this.fecha = fecha;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}