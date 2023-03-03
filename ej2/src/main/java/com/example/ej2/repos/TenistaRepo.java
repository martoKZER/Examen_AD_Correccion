package com.example.ej2.repos;

import com.example.ej2.model.Tenista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenistaRepo extends JpaRepository<Tenista, Long> {

    List<Tenista> findByNombre();


    Optional<Tenista> findByRanking(int ranking);
}
