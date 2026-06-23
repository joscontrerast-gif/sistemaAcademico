package com.saie.evaluacion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluacionServiceTest {

    @Test
    void pruebaBasica() {

        assertEquals(4, 2 + 2);
    }

    @Test
    void textoNoNulo() {

        String valor = "Evaluacion";

        assertNotNull(valor);
    }

    @Test
    void numeroPositivo() {

        assertTrue(10 > 0);
    }
}