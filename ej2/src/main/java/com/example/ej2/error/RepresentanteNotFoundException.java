package com.example.ej2.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RepresentanteNotFoundException extends RuntimeException {
    public RepresentanteNotFoundException(Long id) {
        super("No se encontro el representante con el id: "+id);
    }
}
