package com.example.ej2.repos;

import com.example.ej2.model.Raqueta;
import com.example.ej2.model.Tenista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaquetaRepo extends JpaRepository<Raqueta, Long> {

    List<Raqueta> findByMarca(String marca);

    Raqueta findByTenista(Tenista tenista);
}
