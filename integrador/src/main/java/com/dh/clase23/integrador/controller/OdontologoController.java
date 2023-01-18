package com.dh.clase23.integrador.controller;

import com.dh.clase23.integrador.dominio.Odontologo;
import com.dh.clase23.integrador.service.OdontologoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> lsitarOdontologos(){
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo mostrarOdontologo( @PathVariable int id ){
        return odontologoService.buscarPorId(id);
    }

     
}
