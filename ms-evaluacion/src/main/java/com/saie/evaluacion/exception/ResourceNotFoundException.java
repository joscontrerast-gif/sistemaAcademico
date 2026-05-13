package com.saie.evaluacion.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(
            String mensaje){

        super(mensaje);
    }
}