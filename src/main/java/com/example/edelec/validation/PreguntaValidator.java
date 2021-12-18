package com.example.edelec.validation;

import com.example.edelec.entitys.Pregunta;
import com.example.edelec.entitys.Respuesta;
import com.example.edelec.exception.IncorrectResourceRequestException;

public class PreguntaValidator {
    public static void validate(Pregunta pregunta) {
        if (pregunta.getContenido() == null || pregunta.getContenido().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("Esta pregunta no tiene description");
        }
        if (pregunta.getRespuesta() == null || pregunta.getRespuesta().isEmpty()) {
            throw new IncorrectResourceRequestException("Esta pregunta no tiene respuestas");
        }
        if (pregunta.getTest()==null){
            throw new IncorrectResourceRequestException("Esta pregunta no tiene test");
        }
    }
    public static void validateBase(Pregunta pregunta) {
        if (pregunta.getContenido() == null || pregunta.getContenido().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("Esta pregunta no tiene description");
        }
        if (pregunta.getRespuesta() == null || pregunta.getRespuesta().isEmpty()) {
            throw new IncorrectResourceRequestException("Esta pregunta no tiene respuestas");
        }

    }
}