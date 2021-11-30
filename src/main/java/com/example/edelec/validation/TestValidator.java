package com.example.edelec.validation;

import com.example.edelec.entitys.Test;
import com.example.edelec.exception.IncorrectResourceRequestException;

public class TestValidator {

    public static void validate(Test test){

    if (test.getUsuario().getIdUsuario() == null){
        throw  new IncorrectResourceRequestException("No tiene usuario del test");
    }
    if(test.getPreguntas()==null || test.getPreguntas().isEmpty()){
        throw  new IncorrectResourceRequestException("Este test no tiene preguntas");
    }

    if (test.getDescription()==null || test.getDescription().trim().isEmpty()){
        throw  new IncorrectResourceRequestException("Este test no tiene description");
    }

    }
}
