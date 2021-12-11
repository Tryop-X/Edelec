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
import java.util.*;

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
        test.setActivate(true);
        test.setFecha(LocalDate.now());
        Test test1=testRepository.save(test);
        for ( Pregunta pregunta : test.getPreguntas()){
            pregunta.setTest(test1);
            PreguntaValidator.validate(pregunta);
            Pregunta pregunta1=preguntaRepository.save(pregunta);
            for(Respuesta respuesta: pregunta.getRespuesta()){
                RespuestaValidator.validate(respuesta);
                Carrera carrera= carreraRepository.findById(respuesta.getCarrera().getIdCarrera())
                        .orElseThrow(()-> new ResourceNotFoundException("No Existe la carrera: "+respuesta.getCarrera().getIdCarrera()));
                respuesta.setCarrera(carrera);
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


    @Transactional
    public Test crearTestBase(Test test) {
        test.setIdTest(1);
        TestValidator.validateBase(test);
        test.setDescription("Base de todos lo tests");
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
                respuestaRepository.save(respuesta);
            }
        }

        return test1;
    }

    @Override
    public List<Pregunta> getPreguntasBase(){
        List<Pregunta> preguntas=getTestBase().getPreguntas();
        return preguntas;
    }

    @Transactional
    public Test replaceTestBase(Test test) {
        test.setIdTest(1);
        TestValidator.validateBase(test);
        Test test_base=vaciarTest(getTestBase());
        test.setDescription(test_base.getDescription());
        Test test1=testRepository.save(test_base);
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
                respuestaRepository.save(respuesta);
            }
        }
        return test;
    }

    public void deletePregunta(Integer idPregunta){
        preguntaRepository.deleteById(idPregunta);
    }

    public  void deleteRespuesta(Integer idRespuesta){
        respuestaRepository.deleteById(idRespuesta);
    }

    public Test vaciarTest(Test test){
        for(Pregunta pregunta: test.getPreguntas()) {
            Integer idPregunta=pregunta.getIdPregunta();
            for (Respuesta respuesta: pregunta.getRespuesta()){
                Integer idRespuesta=respuesta.getIdRespuesta();
                deleteRespuesta(idRespuesta);
            }
            deletePregunta(idPregunta);
        }
        test.setPreguntas(null);
        Test testVacio=test;
        return testVacio;
    }


    @Override
    public List<Test> ObtenerTestbyUser(String username) {
        return testRepository.getTestByUser(username);
    }

    @Override
    public String ObtenerResultados(Test test) {
        return null;
    }

    public HashMap<Carrera,Integer> HashResults(Test test){
        HashMap<Carrera,Integer> mapa = new HashMap<>();
        for ( Pregunta pregunta : test.getPreguntas()){
            for(Respuesta respuesta: pregunta.getRespuesta()){
                Carrera carrera= respuesta.getCarrera();
                if (respuesta.getSelect()){
                    if (mapa.containsKey(carrera)) {
                        mapa.put(carrera, mapa.get(carrera) + 1);
                    } else {
                        mapa.put(carrera, 1);
                    }
                }
            }
        }
        return mapa;
    }

    @Override
    public List<Carrera> carrerasRelacionadas(Test test) {
        HashMap<Carrera,Integer>mapa=HashResults(test);
        Integer values[]= new Integer[mapa.size()];
        int count=0;
        for ( Integer i : mapa.values()){
            values[count]=i;
            count=count+1;
        }
        int aux;
        for(int i=0;i<values.length;i++){
            for(int j=0;j<(values.length)-1;i++){
                if(values[j]>values[j+1]){

                }
            }
        }

        return null;
    }

    public Test getTestBase() {
        return testRepository.findById(1)
                .orElseThrow(()-> new ResourceNotFoundException("No ha creado el test base"));
    }


    public void deleteTest(Integer IdTest){
        if(IdTest==1){
            throw new ResourceNotFoundException("No se puede eliminar el test base");
        }
        else{
            testRepository.deleteById(IdTest);
        }
    }

}
