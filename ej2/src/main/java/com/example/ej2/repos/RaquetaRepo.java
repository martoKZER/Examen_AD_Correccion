package com.example.ej2.repos;

import com.example.ej2.model.Raqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaquetaRepo extends JpaRepository<Raqueta, Long> {

}
