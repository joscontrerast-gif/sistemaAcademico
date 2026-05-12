package com.saie.usuarios.dto;

import lombok.Data;

@Data
public class UsuarioRequestDTO {

    private String nombre;

    private String correo;

    private String rol;
}