package com.example.ej2.repos;

import com.example.ej2.model.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepresentanteRepo extends JpaRepository<Representante, Long> {

    List<Representante> findByNombre(String nombre);
}
