package com.saie.asistencia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaResponseDTO {

    private Long id;

    private String estudiante;

    private String asignatura;

    private String fecha;

    private Boolean presente;
}