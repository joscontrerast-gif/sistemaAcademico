package com.saie.academico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicoResponseDTO {

    private Long id;
    private String nombre;
    private String carrera;
    private String asignatura;
    private Double promedio;
}