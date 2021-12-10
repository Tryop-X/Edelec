package com.example.edelec.services;

import com.example.edelec.entitys.Pregunta;
import com.example.edelec.entitys.Test;
import com.example.edelec.entitys.Usuario;

import java.util.List;

public interface TestService {
    Test createTest(List<Pregunta> preguntasRespuesta);
    Test crearTestBase(Test test);
    Test getTestById(Integer IdTest);
    List<Test> ObtenerTestbyUser(String username);
    List<String> ObtenerResultados(Test test);


    void deleteTest(Integer IdTest);
    List<Test> getAllTest();
}
