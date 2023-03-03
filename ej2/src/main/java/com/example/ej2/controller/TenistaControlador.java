package com.example.ej2.controller;


import com.example.ej2.error.TenistaNotFoundException;
import com.example.ej2.model.Tenista;
import com.example.ej2.repos.TenistaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class TenistaControlador {

    @Autowired
    TenistaRepo tenistaRepo;

    @GetMapping("tenistas")
    public ResponseEntity<?> findAll() {
        List<Tenista> result = tenistaRepo.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("tenistas/{id}")
    public Tenista findById(@PathVariable Long id) {
        return tenistaRepo.findById(id).orElseThrow(() -> new TenistaNotFoundException(id));
    }

    @PostMapping("tenistas")
    public ResponseEntity<?> nuevaTenista(@RequestBody Tenista nuevo) {

        Tenista salvada = tenistaRepo.save(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvada);
    }

    @PutMapping("tenistas/{id}")
    public Tenista editarTenista(@RequestBody Tenista editar, @PathVariable Long id) {
        if (tenistaRepo.existsById(id)) {
            editar.setId(id);
            Tenista actualizada = tenistaRepo.save(editar);
            return actualizada;
        } else throw new TenistaNotFoundException(id);
    }

    @DeleteMapping("tenistas/{id}")
    public ResponseEntity<?> borrarTenista(@PathVariable Long id) {
        if (tenistaRepo.existsById(id)) {
            tenistaRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else throw new TenistaNotFoundException(id);
    }

}
