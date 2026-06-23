package com.saie.matricula;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatriculaServiceTest {

    @Test
    void pruebaBasica() {

        assertEquals(4, 2 + 2);
    }

    @Test
    void estadoValido() {

        String estado = "ACTIVA";

        assertNotNull(estado);
    }
    @Test
    void idPositivo() {

        Long id = 1L;

        assertTrue(id > 0);
    }
}