package com.example.edelec.controllers;


import com.example.edelec.entitys.Carrera;
import com.example.edelec.services.CarreraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")

public class CarreraController {

 private CarreraService carreraService;
    @PostMapping
    public ResponseEntity<Carrera> createCarrera(@RequestBody Carrera carrera){
        Carrera carreraNew=carreraService.createsCarrera(carrera);
        return new ResponseEntity<>(carreraNew, HttpStatus.CREATED);
=======
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/Carrera")

public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @PostMapping
    public ResponseEntity<Carrera> createCarrera(@Valid @RequestBody Carrera carrera) {
       Carrera carreraa =carreraService.createCarrera(carrera);
        return new ResponseEntity<>(carreraa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Carrera>> getAllCarrera() {
        List<Carrera> carreras =carreraService.getAllCarrera();
        return new ResponseEntity<>(carreras, HttpStatus.OK);
    }

    @GetMapping("/{carreraId}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable Long IdCarrera) {
        Carrera carrera =carreraService.getCarreraById(IdCarrera);
        return new ResponseEntity<>(carrera, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Carrera> updateCarrera(@RequestBody Carrera carrera) {
        Carrera carrera1 =carreraService.updateCarrera(carrera);
        return new ResponseEntity<>(carrera1, HttpStatus.OK);
    }

    @DeleteMapping("/{carreraId}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable Long IdCarrera) {
        carreraService.deleteCarrera(IdCarrera);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
>>>>>>> a12fa5675f3614a4d4f59a67db95bd404f6016c3
    }
}
