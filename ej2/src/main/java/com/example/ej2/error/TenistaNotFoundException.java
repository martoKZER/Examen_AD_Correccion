package com.example.ej2.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class TenistaNotFoundException extends RuntimeException {
    public TenistaNotFoundException(Long id) {
        super("No se encontro el tenista con el Id: "+id);
    }
}
