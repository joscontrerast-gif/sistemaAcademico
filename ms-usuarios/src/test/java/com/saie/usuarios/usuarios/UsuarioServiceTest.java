package com.saie.usuarios.usuarios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

    @Test
    void sumaCorrecta() {

        int resultado = 2 + 2;

        assertEquals(4, resultado);
    }

    @Test
    void textoNoNulo() {

        String nombre = "Cristian";

        assertNotNull(nombre);
    }

    @Test
    void correoValido() {

        String correo = "test@gmail.com";

        assertTrue(correo.contains("@"));
    }
}