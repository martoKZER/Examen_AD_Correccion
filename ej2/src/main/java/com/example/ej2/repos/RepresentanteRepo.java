package com.example.ej2.repos;

import com.example.ej2.model.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentanteRepo extends JpaRepository<Representante, Long> {

}
