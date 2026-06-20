package com.saie.asistencia.dto;

import lombok.*;

import java.time.LocalDate;

@Data
public class AsistenciaRequestDTO {

    private Long alumnoId;
    private Long cursoId;
    private String estado;
    private LocalDate fecha;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AsistenciaDTO {

        private Long id;
        private Long alumnoId;
        private Long cursoId;
        private String estado;
        private LocalDate fecha;
    }
}