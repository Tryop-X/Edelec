package com.example.edelec.services.impl;


import com.example.edelec.entitys.*;
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
        return testRepository.findById(idTest)
                .orElseThrow(()-> new ResourceNotFoundException("No Existe el test: "+idTest));
    }


    @Override
    public Test createTest(List<Pregunta> preguntasRespuesta) {
        return null;
    }

    @Transactional
    public Test crearTestBase(Test test) {
        test.setIdTest(1);
        TestValidator.validateBase(test);
        Test test1=testRepository.save(test);
        for ( Pregunta pregunta : test.getPreguntas()){
            pregunta.setTest(test1);
            PreguntaValidator.validateBase(pregunta);
            Pregunta pregunta1=preguntaRepository.save(pregunta);
            for(Respuesta respuesta: pregunta.getRespuesta()){
                RespuestaValidator.validateBase(respuesta);
                Carrera carrera= carreraRepository.findById(respuesta.getCarrera().getIdCarrera())
                        .orElseThrow(()-> new ResourceNotFoundException("No Existe la carrera: "+respuesta.getCarrera().getIdCarrera()));
                respuesta.setCarrera(carrera);
                respuesta.setPregunta(pregunta1);
                Respuesta respuesta1 = respuestaRepository.save(respuesta);
            }
        }

        return test1;
    }

    @Override
    public List<Test> ObtenerTestbyUser(String username) {
        return null;
    }

    @Override
    public List<String> ObtenerResultados(Test test) {
        return null;
    }


    public Test getTestBase() {
        return testRepository.findById(1)
                .orElseThrow(()-> new ResourceNotFoundException("No ha creado el test base"));
    }


    public void deleteTest(Integer IdTest){
        if(IdTest==1){
        }
        else{
            testRepository.deleteById(IdTest);
        }
    }

}
