package com.example.ej2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Tenista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nombre;
    int ranking;
    LocalDate fechaNac;
    double altura;
    double peso;
    String manoDominante;
    String tipoReves;
    int puntos;
    String pais;
}
