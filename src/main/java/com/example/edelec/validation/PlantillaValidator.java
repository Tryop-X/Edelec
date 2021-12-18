package com.example.edelec.validation;

import com.example.edelec.entitys.Plantilla;
import com.example.edelec.exception.IncorrectResourceRequestException;


public class PlantillaValidator {
    public static void validate(Plantilla plantilla){
        if (plantilla.getPreguntas().isEmpty() || plantilla.getPreguntas()==null){
            throw new IncorrectResourceRequestException("No tiene preguntas");
        }
    }
}
