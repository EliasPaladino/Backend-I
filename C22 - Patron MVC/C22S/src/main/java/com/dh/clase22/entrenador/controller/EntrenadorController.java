package com.dh.clase22.entrenador.controller;

import com.dh.clase22.entrenador.domain.Entrenador;
import com.dh.clase22.entrenador.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/")
    public List<Entrenador> listarEntrenadores() {
        return entrenadorService.listaEntrenadores();
    }
}
