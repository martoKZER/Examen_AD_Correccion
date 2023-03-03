package com.example.ej1.controller;

import com.example.ej1.model.Coche;
import com.example.ej1.model.Moto;
import com.example.ej1.service.MiServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class Controlador {
    @Autowired
    MiServicio miServicio;
    @GetMapping("saluda")
    public Map Saluda(){
        Map<String, String> contenido = new HashMap<>();
        contenido.put("contenido", "Bienvenido al servicio de calculo de ITMV");
        return contenido;
    }
    @PostMapping("calculoPFcoche")
    public ResponseEntity<?> calculaCoche(@RequestBody Coche coche){
        Map<String, String> calculo = miServicio.calculaPFcoche(coche);
        return ResponseEntity.ok(calculo);
    }
    @PostMapping("calculoPFmoto")
    public ResponseEntity<?> calculaMoto(@RequestBody Moto moto){
        Map<String, String> calculo = miServicio.calculaPFmoto(moto);
        return ResponseEntity.ok(calculo);
    }

}
