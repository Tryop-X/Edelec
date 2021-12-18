package com.example.edelec.controllers;

import com.example.edelec.entitys.Plantilla;
import com.example.edelec.entitys.Sede;
import com.example.edelec.entitys.Test;
import com.example.edelec.services.PlantillaService;
import com.example.edelec.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/plantilla")
public class PlantillaController {

    private final PlantillaService plantillaService;

    public PlantillaController(PlantillaService plantillaService) {
        this.plantillaService = plantillaService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Plantilla>> createPlantilla(@RequestBody Plantilla plantilla) {
        Plantilla newPlantilla =plantillaService.createPlatilla(plantilla);
        return  new WrapperResponse<Plantilla>(true,"success",newPlantilla).createResponse(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Plantilla>>> getAllPlantillas() {
        List<Plantilla> plantillas =plantillaService.listarPlantillas();
        return  new WrapperResponse<List<Plantilla>>(true,"success",plantillas).createResponse(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<WrapperResponse<Plantilla>> getPlantillaById(@PathVariable("id") Integer id) {
        Plantilla plantilla=plantillaService.getPlantillaById(id);
        return  new WrapperResponse<Plantilla>(true,"success",plantilla).createResponse(HttpStatus.OK);
    }
    @GetMapping("/actual")
    public ResponseEntity<WrapperResponse<Plantilla>> getPlantillaActual() {
        Plantilla plantilla=plantillaService.getPlantillaActual();
        return  new WrapperResponse<Plantilla>(true,"success",plantilla).createResponse(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WrapperResponse<Plantilla>> ReplaceTestBase(@RequestBody Plantilla plantilla, @PathVariable Integer id ) {
        Plantilla plantilla1=plantillaService.editPlantilla(plantilla, id) ;
        return  new WrapperResponse<Plantilla>(true,"success",plantilla1).createResponse(HttpStatus.OK);
    }


    @GetMapping("/activar/{id}")
    public ResponseEntity<WrapperResponse<Plantilla>> activarPlantilla(@PathVariable("id") Integer id) {
        Plantilla plantilla=plantillaService.activarPlantilla(id);
        return  new WrapperResponse<Plantilla>(true,"success",plantilla).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteTest(@PathVariable("id") Integer idTest){
        plantillaService.deletePlatilla(idTest);
        return new WrapperResponse<Void>(true,"success",null).createResponse(HttpStatus.NO_CONTENT);
    }
}
