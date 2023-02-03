package com.dh.clase23.integrador.controller;

import com.dh.clase23.integrador.dominio.Turno;
import com.dh.clase23.integrador.service.OdontologoService;
import com.dh.clase23.integrador.service.PacienteService;
import com.dh.clase23.integrador.service.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;
    private final OdontologoService odontologoService;
    private final PacienteService pacienteService;

    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    @GetMapping("/{id}")
    public Turno buscarPorId(@PathVariable int id) {
        return turnoService.buscarPorId(id);
    }

    @GetMapping
    public List<Turno> listarTurnos() {
        return turnoService.listarTurnos();
    }

    @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno) {
         ResponseEntity<Turno> mensaje;

        if (odontologoService.buscarPorId(turno.getOdontologo().getId())!=null && pacienteService.buscarPorId(turno.getPaciente().getId())!=null) {
            mensaje = ResponseEntity.ok(turnoService.guardarTurno(turno));
        } else {
            mensaje = ResponseEntity.badRequest().build();
        }
        return mensaje;
    }

    @PutMapping
    public Turno actualizarTurno(@RequestBody Turno turno) {
        return turnoService.actualizarTurno(turno);
    }



}
