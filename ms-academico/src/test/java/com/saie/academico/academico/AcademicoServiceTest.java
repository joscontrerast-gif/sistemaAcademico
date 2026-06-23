package com.saie.academico.academico;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcademicoServiceTest {

    @Test
    void pruebaBasica() {

        assertEquals(4, 2 + 2);
    }

    @Test
    void nombreNoNulo() {

        String nombre = "Ingenieria";

        assertNotNull(nombre);
    }

    @Test
    void promedioValido() {

        double promedio = 55.5;

        assertTrue(promedio > 0);
    }
}