package com.example.edelec.services;

import com.example.edelec.entitys.*;

import java.util.List;

public interface TestService {
    Test createTest(Test test);
    Test getTestById(Integer IdTest);
    Plantilla ObtenerPLantilla();
    List<Test> ObtenerTestbyUser(String username);
    String obtenerResultados(Integer id);
    List<Carrera> carrerasRelacionadas(Integer id);

    void deleteTest(Integer IdTest);
    List<Test> getAllTest();
}
