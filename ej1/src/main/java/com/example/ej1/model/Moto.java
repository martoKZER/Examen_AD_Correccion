package com.example.ej1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moto {
    private String matricula;
    private float tiempo;
    private float recorrido;
    private float cilindros;
    private float cilindrada;
}
