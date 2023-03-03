package com.example.ej2.controller;

import com.example.ej2.error.RaquetaNotFoundException;
import com.example.ej2.model.Raqueta;
import com.example.ej2.repos.RaquetaRepo;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class RaquetaControlador {
    @Autowired
    RaquetaRepo raquetaRepo;

    @GetMapping("raquetas")
    public ResponseEntity<?> findAll() {
        List<Raqueta> result = raquetaRepo.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("raquetas/{id}")
    public Raqueta findById(@PathVariable Long id) {
        return raquetaRepo.findById(id).orElseThrow(() -> new RaquetaNotFoundException(id));
    }

    @PostMapping("raquetas")
    public ResponseEntity<?> nuevaRaqueta(@RequestBody Raqueta nuevo) {
        if (nuevo.getRepresentante() != null) {
            Raqueta salvada = raquetaRepo.save(nuevo);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvada);
        } else return ResponseEntity.badRequest().build();
    }

    @PutMapping("raquetas/{id}")
    public Raqueta editarRaqueta(@RequestBody Raqueta editar, @PathVariable Long id) {
        if (raquetaRepo.existsById(id)) {
            editar.setId(id);
            Raqueta actualizada = raquetaRepo.save(editar);
            return actualizada;
        } else throw new RaquetaNotFoundException(id);
    }

    @DeleteMapping("raquetas/{id}")
    public ResponseEntity<?> borrarRaqueta(@PathVariable Long id) {
        if (raquetaRepo.existsById(id)) {
            raquetaRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else throw new RaquetaNotFoundException(id);
    }

}
