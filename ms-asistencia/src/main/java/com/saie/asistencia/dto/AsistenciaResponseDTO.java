package com.saie.asistencia.dto;

import com.saie.asistencia.dto.external.AcademicoDTO;
import com.saie.asistencia.dto.external.UsuarioDTO;
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

    private Long academicoId;

    private Long usuarioId;

    private String estudiante;

    private String asignatura;

    private String fecha;

    private Boolean presente;

    private UsuarioDTO usuario;

    private AcademicoDTO academico;
}