package com.example.ej2.repos;

import com.example.ej2.model.Tenista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenistaRepo extends JpaRepository<Tenista, Long> {

}
