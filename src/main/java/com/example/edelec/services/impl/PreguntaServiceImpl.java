package com.example.edelec.services.impl;

import com.example.edelec.entitys.Pregunta;
import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.PreguntaRepository;
import com.example.edelec.services.PreguntaService;
import com.example.edelec.validation.PreguntaValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public PreguntaServiceImpl(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }


    @Override
    public Pregunta createPregunta(Pregunta pregunta) {
        PreguntaValidator.validate(pregunta);
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Pregunta createPreguntaBase(Pregunta pregunta) {
        PreguntaValidator.validateBase(pregunta);
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Pregunta getPregunta(Integer id) {
        return preguntaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No Existe pregunta: "+id));
    }

    @Override
    public List<Pregunta> listarPreguntas() {
        return preguntaRepository.findAll();
    }

    @Override
    public void deletePregunta(Integer idPregunta){
        preguntaRepository.deleteById(idPregunta);
    }
}
