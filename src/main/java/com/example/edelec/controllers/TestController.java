package com.example.edelec.controllers;


import com.example.edelec.entitys.Test;

import com.example.edelec.entitys.Usuario;
import com.example.edelec.services.TestService;

import com.example.edelec.utils.WrapperResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/base")
    public ResponseEntity<WrapperResponse<Test>> createTestBase(@RequestBody Test test) {
        System.out.println("creado"+test);
        Test testNew =testService.crearTestBase(test);
        return  new WrapperResponse<Test>(true,"success",testNew).createResponse(HttpStatus.CREATED);
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

    /*@PutMapping("/base")
    public ResponseEntity<Test> ReplaceTestBase(@RequestBody Test test) {
        System.out.println("creado"+test);
        Test testactualizar =testService.crearTestBase(test) ;
        return new ResponseEntity<>(testactualizar, HttpStatus.OK);
    }
*/
    @DeleteMapping("/{idTest}")
    public ResponseEntity<Void> deleteTest(@PathVariable("idTest") Integer idTest){
        testService.deleteTest(idTest);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
