package com.dh.clase23.integrador.controller;

import com.dh.clase23.integrador.dominio.Paciente;
import com.dh.clase23.integrador.service.PacienteService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/index")
    public String traerPaciente(Model model, @RequestParam("email") String email){
        Paciente paciente = pacienteService.buscarPorEmail(email);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "index";
    }
}
