package com.example.edelec.services;


import com.example.edelec.entitys.Pregunta;

import java.util.List;

public interface PreguntaService {
    Pregunta createPregunta(Pregunta pregunta);
    Pregunta getPregunta(Integer id);
    List<Pregunta> listarPreguntas();
    Pregunta createPreguntaBase(Pregunta pregunta);
    void deletePregunta(Integer idPregunta);
}
