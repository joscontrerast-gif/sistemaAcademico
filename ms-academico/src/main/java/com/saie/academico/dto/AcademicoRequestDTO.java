package com.saie.academico.dto;

import lombok.Data;

@Data
public class AcademicoRequestDTO {

    private String nombre;
    private String carrera;
    private String asignatura;
    private Double promedio;
}