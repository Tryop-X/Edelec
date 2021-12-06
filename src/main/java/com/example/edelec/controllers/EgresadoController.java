package com.example.edelec.controllers;


import com.example.edelec.services.EgresadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/egresado")
public class EgresadoController {

    private final EgresadoService egresadoService;

    public EgresadoController(EgresadoService egresadoService) {
        this.egresadoService = egresadoService;
    }



}
