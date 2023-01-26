package com.dh.clase23.integrador.controller;

import com.dh.clase23.integrador.dominio.Turno;
import com.dh.clase23.integrador.service.TurnoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public List<Turno> listarTurnos() {
        return turnoService.listarTurnos();
    }

}
