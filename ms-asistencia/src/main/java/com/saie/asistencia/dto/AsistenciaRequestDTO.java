package com.saie.asistencia.dto;

import lombok.Data;

@Data
public class AsistenciaRequestDTO {

    private String estudiante;

    private String asignatura;

    private String fecha;

    private Boolean presente;
}