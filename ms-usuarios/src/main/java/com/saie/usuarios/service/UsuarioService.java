package com.saie.usuarios.service;

import com.saie.usuarios.dto.UsuarioDTO;
import com.saie.usuarios.dto.UsuarioRequestDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listar();

    UsuarioDTO obtener(Long id);

    UsuarioDTO guardar(UsuarioRequestDTO dto);

    UsuarioDTO actualizar(Long id, UsuarioRequestDTO dto);

    void eliminarUsuario(Long id);
}