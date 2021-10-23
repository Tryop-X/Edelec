package com.example.edelec.controllers;


import com.example.edelec.entitys.Carrera;
import com.example.edelec.services.CarreraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class CarreraController {

    private CarreraService carreraService;
    @PostMapping
    public ResponseEntity<Carrera> createCarrera(@RequestBody Carrera carrera){
        Carrera carreraNew=carreraService.createsCarrera(carrera);
        return new ResponseEntity<>(carreraNew, HttpStatus.CREATED);
    }
}
