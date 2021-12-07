package com.example.edelec.services.impl;


import com.example.edelec.entitys.Pregunta;
import com.example.edelec.entitys.Respuesta;
import com.example.edelec.entitys.Test;
import com.example.edelec.entitys.Usuario;
import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.*;
import com.example.edelec.services.TestService;

import com.example.edelec.validation.PreguntaValidator;
import com.example.edelec.validation.RespuestaValidator;
import com.example.edelec.validation.TestValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final UsuarioRepository usuarioRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestaRepository respuestaRepository;
    private final CarreraRepository carreraRepository;

    public TestServiceImpl(TestRepository testRepository, UsuarioRepository usuarioRepository, PreguntaRepository preguntaRepository, RespuestaRepository respuestaRepository, CarreraRepository carreraRepository) {
        this.testRepository = testRepository;
        this.usuarioRepository = usuarioRepository;
        this.preguntaRepository = preguntaRepository;
        this.respuestaRepository = respuestaRepository;
        this.carreraRepository = carreraRepository;
    }

    @Transactional
    public Test createTest (Test test){
        TestValidator.validate(test);
        Usuario usuario= usuarioRepository.findById(test.getUsuario().getIdUsuario())
                .orElseThrow(()-> new ResourceNotFoundException("No Existe el usuario: "+test.getUsuario().getIdUsuario()));
        test.setUsuario(usuario);
        test.setFecha(LocalDate.now());
        Test test1=testRepository.save(test);
        for ( Pregunta pregunta : test.getPreguntas()){
            pregunta.setTest(test1);
            PreguntaValidator.validate(pregunta);
            Pregunta pregunta1=preguntaRepository.save(pregunta);
            for(Respuesta respuesta: pregunta.getRespuesta()){
                respuesta.setPregunta(pregunta1);
                RespuestaValidator.validate(respuesta);
                respuestaRepository.save(respuesta);
            }
        }
        return test1;
    }

    @Override
    public List<Test> getAllTest() {
        return testRepository.findAll();
    }

    @Override
    public Test getTestById(Integer idTest) {
        return testRepository.findById(idTest).orElseThrow();
    }

    public Test replaceTestBase(Test test) {
        test.setIdTest(1);
        TestValidator.validate(test);
        test.setFecha(LocalDate.now());
        Test test1=testRepository.save(test);
        for ( Pregunta pregunta : test.getPreguntas()){
            pregunta.setTest(test1);
            PreguntaValidator.validate(pregunta);
            Pregunta pregunta1=preguntaRepository.save(pregunta);
            for(Respuesta respuesta: pregunta.getRespuesta()){
                respuesta.setPregunta(pregunta1);
                RespuestaValidator.validate(respuesta);
                respuestaRepository.save(respuesta);
            }
        }
        return test1;
    }

    public void deleteTest(Integer IdTest){
        testRepository.deleteById(IdTest);
    }

}
