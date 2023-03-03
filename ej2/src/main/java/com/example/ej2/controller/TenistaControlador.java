package com.example.ej2.controller;


import com.example.ej2.error.TenistaNotFoundException;
import com.example.ej2.model.Raqueta;
import com.example.ej2.model.Tenista;
import com.example.ej2.repos.RaquetaRepo;
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
    @Autowired
    RaquetaRepo raquetaRepo;

    @CrossOrigin(origins = "**")
    @GetMapping("tenistas")
    public ResponseEntity<?> findAll() {
        List<Tenista> result = tenistaRepo.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "**")
    @GetMapping("tenistas/{id}")
    public Tenista findById(@PathVariable Long id) {
        return tenistaRepo.findById(id).orElseThrow(() -> new TenistaNotFoundException(id));
    }
    @CrossOrigin(origins = "http://localhost:8888")
    @PostMapping("tenistas")
    public ResponseEntity<?> nuevaTenista(@RequestBody Tenista nuevo) {

        Tenista salvada = tenistaRepo.save(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvada);
    }
    @CrossOrigin(origins = "http://localhost:8888")
    @PutMapping("tenistas/{id}")
    public Tenista editarTenista(@RequestBody Tenista editar, @PathVariable Long id) {
        if (tenistaRepo.existsById(id)) {
            editar.setId(id);
            Tenista actualizada = tenistaRepo.save(editar);
            return actualizada;
        } else throw new TenistaNotFoundException(id);
    }
    @CrossOrigin(origins = "http://localhost:8888")
    @DeleteMapping("tenistas/{id}")
    public ResponseEntity<?> borrarTenista(@PathVariable Long id) {
        if (tenistaRepo.existsById(id)) {
            tenistaRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else throw new TenistaNotFoundException(id);
    }

    @CrossOrigin(origins = "**")
    @GetMapping("tenistas/find{nombre}")
    public ResponseEntity<?> findNombre(@RequestParam String nombre){
        List<Tenista> tenistas = tenistaRepo.findByNombre();
        return ResponseEntity.ok(tenistas);
    }

    @CrossOrigin(origins = "**")
    @GetMapping("tenistas/{id}/raqueta")
    public ResponseEntity<?> findRaquetaDadoIdTenista(@PathVariable Long id){
        if (tenistaRepo.existsById(id)){
            Tenista tenista = tenistaRepo.findById(id).get();
            Raqueta raqueta = raquetaRepo.findByTenista(tenista);
            return ResponseEntity.ok(raqueta);
        }
        throw new TenistaNotFoundException(id);
    }

    @CrossOrigin(origins = "**")
    @GetMapping("/tenistas/ranking/{ranking}")
    public ResponseEntity<?> findTenistaByRanking(@PathVariable int ranking){
        if (tenistaRepo.findByRanking(ranking).isPresent()){
            Tenista tenista = tenistaRepo.findByRanking(ranking).get();
            return ResponseEntity.ok(tenista);
        } else throw new TenistaNotFoundException(ranking);
    }
}
