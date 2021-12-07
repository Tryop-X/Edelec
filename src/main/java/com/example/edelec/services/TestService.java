package com.example.edelec.services;

import com.example.edelec.entitys.Test;
import com.example.edelec.entitys.Usuario;

import java.util.List;

public interface TestService {
    Test createTest(Test test);
    Test getTestById(Integer IdTest);
    Test replaceTestBase(Test test);

    void deleteTest(Integer IdTest);
    List<Test> getAllTest();
}
