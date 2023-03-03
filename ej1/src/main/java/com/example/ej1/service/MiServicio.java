package com.example.ej1.service;

import com.example.ej1.model.Coche;
import com.example.ej1.model.Moto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MiServicio {
    public Map<String, String> calculaPFcoche(Coche coche) {
        double pf = Math.pow(((double) coche.getCilindrada() / (double) coche.getCilindros()), 0) * 0.08 * coche.getCilindros();
        Map<String, String> calculo = new HashMap<>();
        calculo.put("Potencia Fiscal: ", pf + "");
        return calculo;
    }

    public Map<String, String> calculaPFmoto(Moto moto) {
        double pf;
        if ((int) moto.getTiempo() == 2) {
            pf = 0.08 * Math.pow(moto.getCilindrada() / moto.getCilindros(), 0.6) * moto.getCilindros();
        } else {
            pf = 0.11 * Math.pow(moto.getCilindrada() / moto.getCilindros(), 0.6) * moto.getCilindros();
        }
        Map<String, String> calculo = new HashMap<>();
        calculo.put("Potencia Fiscal: ", pf + "");
        return calculo;
    }
}
