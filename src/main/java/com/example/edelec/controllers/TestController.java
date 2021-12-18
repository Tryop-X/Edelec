package com.example.edelec.controllers;


import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Pregunta;
import com.example.edelec.entitys.Test;


import com.example.edelec.services.TestService;

import com.example.edelec.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }



    @PostMapping
    public ResponseEntity<WrapperResponse<Test>> createTest(@RequestBody Test test) {
        Test testNew =testService.createTest(test);
        return  new WrapperResponse<Test>(true,"success",testNew).createResponse(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Test>>> getAllTest() {
        List<Test> tests =testService.getAllTest();
        return  new WrapperResponse<List<Test>>(true,"success",tests).createResponse(HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<WrapperResponse<List<Test>>> getTestByUser(@PathVariable("username") String username) {
        List<Test> tests =testService.ObtenerTestbyUser(username);
        return  new WrapperResponse<List<Test>>(true,"success",tests).createResponse(HttpStatus.OK);
    }

    @GetMapping("/id/{idTest}")
    public ResponseEntity<WrapperResponse<Test>> getTestById(@PathVariable("idTest") Integer idTest) {
       Test test=testService.getTestById(idTest);
        return  new WrapperResponse<Test>(true,"success",test).createResponse(HttpStatus.OK);
    }


    @DeleteMapping("/{idTest}")
    public ResponseEntity<WrapperResponse<Void>> deleteTest(@PathVariable("idTest") Integer idTest){
        testService.deleteTest(idTest);
        return new WrapperResponse<Void>(true,"success",null).createResponse(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/resultados/{id}")
    public ResponseEntity<WrapperResponse<String>> getResults(@PathVariable("id") Integer id){
        String descrition=testService.obtenerResultados(id);
        return new WrapperResponse<String>(true,"success",descrition).createResponse(HttpStatus.OK);
    }
    @GetMapping("/relacionado/{id}")
    public ResponseEntity<WrapperResponse<List<Carrera>>> getRelaciones(@PathVariable("id") Integer id){
        List<Carrera> carreras=testService.carrerasRelacionadas(id);
        return new WrapperResponse<List<Carrera>>(true,"success",carreras).createResponse(HttpStatus.OK);
    }
}
