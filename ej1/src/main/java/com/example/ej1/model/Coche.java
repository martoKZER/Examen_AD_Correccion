package com.example.ej1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coche {
    public String matricula;
    public int cilindros;
    public int cilindrada;
    public int potencia;
}
