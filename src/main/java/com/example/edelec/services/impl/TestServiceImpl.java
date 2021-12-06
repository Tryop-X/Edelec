package com.example.edelec.services.impl;

import com.example.edelec.entitys.Pregunta;
import com.example.edelec.entitys.Respuesta;
import com.example.edelec.entitys.Test;
import com.example.edelec.entitys.Usuario;
import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.PreguntaRepository;
import com.example.edelec.repositories.RespuestaRepository;
import com.example.edelec.repositories.TestRepository;
import com.example.edelec.repositories.UsuarioRepository;
import com.example.edelec.services.TestService;
import com.example.edelec.validation.PreguntaValidator;
import com.example.edelec.validation.RespuestaValidator;
import com.example.edelec.validation.TestValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestaRepository respuestaRepository;
    private final UsuarioRepository usuarioRepository;

    public TestServiceImpl(TestRepository testRepository, PreguntaRepository preguntaRepository, RespuestaRepository respuestaRepository, UsuarioRepository usuarioRepository) {
        this.testRepository = testRepository;
        this.preguntaRepository = preguntaRepository;
        this.respuestaRepository = respuestaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Test createTest (Test test){
        TestValidator.validate(test);
        Usuario usuario=usuarioRepository.findById(test.getUsuario().getIdUsuario())
                .orElseThrow(()->new ResourceNotFoundException("No Existe el usuario: "+test.getUsuario().getIdUsuario()));
        test.setUsuario(usuario);
        test.setFecha(LocalDateTime.now());
        testRepository.save(test);
        usuario.getTests().add(test);
        for (Pregunta pregunta : test.getPreguntas()){
            PreguntaValidator.validate(pregunta);
            pregunta.setTest(test);
            preguntaRepository.save(pregunta);
            for (Respuesta respuesta: pregunta.getRespuesta()){
                respuesta.setPregunta(pregunta);
                respuestaRepository.save(respuesta);
            }
        }
        return test;
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
