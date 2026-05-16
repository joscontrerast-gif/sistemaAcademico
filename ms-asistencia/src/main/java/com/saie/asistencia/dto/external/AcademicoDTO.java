package com.saie.asistencia.dto.external;

import lombok.Data;

@Data
public class AcademicoDTO {

    private Long id;

    private String nombre;

    private String carrera;

    private String asignatura;

    private Double promedio;
}