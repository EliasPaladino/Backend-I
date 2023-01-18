package com.dh.clase23.integrador.controller;

import com.dh.clase23.integrador.dominio.Odontologo;
import com.dh.clase23.integrador.dominio.Paciente;
import com.dh.clase23.integrador.service.OdontologoService;
import com.dh.clase23.integrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/index")
    public String traerPaciente(Model model, @RequestParam("email") String email){
        Paciente paciente = pacienteService.buscarPorEmail(email);
        Odontologo odontologo = paciente.getOdontologo();
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        model.addAttribute("nombreOdontologo", odontologo.getNombre());
        model.addAttribute("apellidoOdontologo", odontologo.getApellido());
        return "index";
    }

    @GetMapping
    public List<Paciente> listarPacientes(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public Paciente mostrarPaciente(@PathVariable int id){
        return pacienteService.buscarPorId(id);
    }

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }

    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizar(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        pacienteService.eliminar(id);
    }

}
