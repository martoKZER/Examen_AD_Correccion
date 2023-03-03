package com.example.ej2.controller;

import com.example.ej2.error.RepresentanteNotFoundException;
import com.example.ej2.model.Representante;
import com.example.ej2.repos.RepresentanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/")
@RestController
public class RepresentanteControlador {

    @Autowired
    RepresentanteRepo representanteRepo;

    @GetMapping("representante")
    public ResponseEntity<?> findAll() {
        List<Representante> result = representanteRepo.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("representante/{id}")
    public Representante findById(@PathVariable Long id) {
        return representanteRepo.findById(id).orElseThrow(() -> new RepresentanteNotFoundException(id));
    }

    @PostMapping("representante")
    public ResponseEntity<?> nuevaRepresentante(@RequestBody Representante nuevo) {
            Representante salvada = representanteRepo.save(nuevo);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvada);
    }

    @PutMapping("representante/{id}")
    public Representante editarRepresentante(@RequestBody Representante editar, @PathVariable Long id) {
        if (representanteRepo.existsById(id)) {
            editar.setId(id);
            Representante actualizada = representanteRepo.save(editar);
            return actualizada;
        } else throw new RepresentanteNotFoundException(id);
    }

    @DeleteMapping("representante/{id}")
    public ResponseEntity<?> borrarRepresentante(@PathVariable Long id) {
        if (representanteRepo.existsById(id)) {
            representanteRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else throw new RepresentanteNotFoundException(id);
    }

}
