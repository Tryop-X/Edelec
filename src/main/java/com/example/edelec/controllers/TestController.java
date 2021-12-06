package com.example.edelec.controllers;


import com.example.edelec.entitys.Test;

import com.example.edelec.entitys.Usuario;
import com.example.edelec.services.TestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public ResponseEntity<Test> createTest(@RequestBody Test test) {
        Test testNew =testService.createTest(test);
        return  new ResponseEntity<Test>(testNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Test>> getAllTest() {
        List<Test> test =testService.getAllTest();
        return new ResponseEntity<>(test, HttpStatus.OK);
    }
    @GetMapping("/id/{idTest}")
    public ResponseEntity<Test> getTestById(@PathVariable("idTest") Integer idTest) {
       Test test=testService.getTestById(idTest);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Test> updateTest(@RequestBody Test test) {
        Test testactualizar =testService.updateTest(test);
        return new ResponseEntity<>(testactualizar, HttpStatus.OK);
    }

    @DeleteMapping("/{idTest}")
    public ResponseEntity<Void> deleteTest(@PathVariable("idTest") Integer idTest){
        testService.deleteTest(idTest);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
