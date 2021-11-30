package com.example.edelec.services.impl;

import com.example.edelec.entitys.Test;
import com.example.edelec.entitys.Usuario;
import com.example.edelec.repositories.TestRepository;
import com.example.edelec.services.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    public Test createTest (Test test){
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAllTest() {
        return testRepository.findAll();
    }

    @Override
    public Test getTestById(Integer idTest) {
        return testRepository.getById(idTest);
    }

    @Override
    public Test updateTest(Test test) {
        return testRepository.save(test);
    }

    public void deleteTest(Integer IdTest){
        testRepository.deleteById(IdTest);
    }

}
