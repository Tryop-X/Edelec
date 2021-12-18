package com.example.edelec.services.impl;

import com.example.edelec.entitys.*;
import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.PlantillaRepository;
import com.example.edelec.services.CarreraService;
import com.example.edelec.services.PlantillaService;
import com.example.edelec.services.PreguntaService;
import com.example.edelec.services.RespuestaService;
import com.example.edelec.validation.PlantillaValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantillaServiceImpl implements PlantillaService {
    private final PlantillaRepository plantillaRepository;
    private final PreguntaService preguntaService;
    private final RespuestaService respuestaService;
    private final CarreraService carreraService;

    public PlantillaServiceImpl(PlantillaRepository plantillaRepository, PreguntaService preguntaService, RespuestaService respuestaService, CarreraService carreraService) {
        this.plantillaRepository = plantillaRepository;
        this.preguntaService = preguntaService;
        this.respuestaService = respuestaService;
        this.carreraService = carreraService;
    }

    @Override
    public Plantilla createPlatilla(Plantilla plantilla) {
        plantilla.setActivate(false);
        PlantillaValidator.validate(plantilla);
        Plantilla plantilla1 =plantillaRepository.save(plantilla);
        for ( Pregunta pregunta : plantilla.getPreguntas()){
            pregunta.setPlantilla(plantilla1);
            Pregunta pregunta1=preguntaService.createPreguntaBase(pregunta);
            for(Respuesta respuesta: pregunta.getRespuesta()){
                Carrera carrera= carreraService.getCarreraById(respuesta.getCarrera().getIdCarrera());
                respuesta.setCarrera(carrera);
                respuesta.setPregunta(pregunta1);
                respuestaService.createRespuestaBase(respuesta);
            }

        }
        return plantilla1;
    }

    @Override
    public Plantilla getPlantillaActual() {
        Plantilla plantilla=plantillaRepository.BuscarPlantillaActual();
        if(plantilla==null){
            throw new ResourceNotFoundException("No hay una plantilla actual");
        }
        return plantilla;
    }



    @Override
    public Plantilla activarPlantilla(Integer id) {
        Plantilla plantilla=getPlantillaById(id);
        Plantilla actual=plantillaRepository.BuscarPlantillaActual();
        if(actual==null){
            plantilla.setActivate(true);
            return plantillaRepository.save(plantilla);
        }
        else {

            if(plantilla==actual){
                throw new ResourceNotFoundException("Esta plantilla ya es la activa");
            }
            else {
                actual.setActivate(false);
                plantillaRepository.save(actual);
                plantilla.setActivate(true);
                return plantillaRepository.save(plantilla);
            }
        }
    }


    @Override
    public List<Plantilla> listarPlantillas() {
        return plantillaRepository.findAll();
    }



    @Override
    public Plantilla getPlantillaById(Integer id){
        return plantillaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No Existe la plantilla: "+id));
    }

    @Override
    public Plantilla editPlantilla(Plantilla plantilla, Integer id){
        PlantillaValidator.validate(plantilla);
        Plantilla plantilla2 = vaciarP(id);
        Plantilla plantilla1 =plantillaRepository.save(plantilla2);
        for ( Pregunta pregunta : plantilla.getPreguntas()){
            pregunta.setPlantilla(plantilla1);
            Pregunta pregunta1=preguntaService.createPreguntaBase(pregunta);
            for(Respuesta respuesta: pregunta.getRespuesta()){
                Carrera carrera= carreraService.getCarreraById(respuesta.getCarrera().getIdCarrera());
                respuesta.setCarrera(carrera);
                respuesta.setPregunta(pregunta1);
                respuestaService.createRespuestaBase(respuesta);
            }

        }
        plantilla.setIdPlantillas(id);
        return plantilla;

    }


    public Plantilla vaciarP(Integer id){
        for(Pregunta pregunta: getPlantillaById(id).getPreguntas()) {
            for (Respuesta respuesta :pregunta.getRespuesta()) {
                respuestaService.deleteRespuesta(respuesta.getIdRespuesta());
            }
            preguntaService.deletePregunta(pregunta.getIdPregunta());
        }
        getPlantillaById(id).setPreguntas(null);
        return getPlantillaById(id);
    }



    @Override
    public void deletePlatilla(Integer id){
        if (getPlantillaActual().getIdPlantillas()==id){
            throw new ResourceNotFoundException("No se puede eliminar la plantilla activa");
        }
        plantillaRepository.deleteById(id);
    }

}
