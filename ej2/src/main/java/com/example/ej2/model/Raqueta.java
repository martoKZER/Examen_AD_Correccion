package com.example.ej2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Raqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String marca;
    double precio;
    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    Representante representante;

    @OneToMany
    @JoinColumn(name = "raquetaID")
    private List<Tenista> tenistas;
}
