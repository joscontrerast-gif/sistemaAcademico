package com.saie.matricula.dto;

public class MatriculaRequestDTO {

    private Long estudianteId;

    private Long cursoId;

    private String estado;

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
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
}