package com.example.edelec.controllers;

import com.example.edelec.services.UniversidadService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversidadController {

    private final UniversidadService universidadService;

    public UniversidadController(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    public void getUniversidadById() {

    }

    public void updateUniversity() {

    }

}
