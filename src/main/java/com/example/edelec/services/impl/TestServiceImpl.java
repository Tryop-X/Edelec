package com.example.edelec.services.impl;


import com.example.edelec.entitys.*;
import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.*;
import com.example.edelec.services.*;


import com.example.edelec.validation.TestValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final UsuarioService usuarioService;
    private final PreguntaService preguntaService;
    private final RespuestaService respuestaService;
    private final PlantillaService plantillaService;

    public TestServiceImpl(
            TestRepository testRepository,
            UsuarioService usuarioService,
            PreguntaService preguntaService,
            RespuestaService respuestaService,
            PlantillaService plantillaService) {
        this.testRepository = testRepository;
        this.usuarioService = usuarioService;
        this.preguntaService = preguntaService;
        this.respuestaService = respuestaService;
        this.plantillaService = plantillaService;
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
    public Plantilla ObtenerPLantilla() {
        return plantillaService.getPlantillaActual();
    }




    @Transactional
    public Test createTest (Test test){
        TestValidator.validate(test);
        Usuario usuario= usuarioService.getUsuarioById(test.getUsuario().getIdUsuario());
        test.setUsuario(usuario);
        test.setActivate(true);
        test.setFecha(LocalDate.now());
        List<Pregunta> preguntasBase=ObtenerPLantilla().getPreguntas();
        List<Pregunta> preguntas=test.getPreguntas();
        test.setPreguntas(new ArrayList<>());
        Test test1=testRepository.save(test);
        for ( int i = 0; i <preguntas.size(); ++i){
            Pregunta preguntaBase=preguntasBase.get(i);
            Pregunta pregunta=preguntas.get(i);
            pregunta.setContenido(preguntaBase.getContenido());
            pregunta.setPlantilla(preguntaBase.getPlantilla());
            pregunta.setTest(test1);
            Pregunta pregunta1=preguntaService.createPregunta(pregunta);
            for(int f = 0; f <pregunta.getRespuesta().size(); ++f){
                Respuesta respuesta= pregunta.getRespuesta().get(f);
                Respuesta respuestaBase= preguntaBase.getRespuesta().get(f);
                respuesta.setContenidoRespuesta(respuestaBase.getContenidoRespuesta());
                respuesta.setCarrera(respuestaBase.getCarrera());
                respuesta.setPregunta(pregunta1);
                respuestaService.createRespuestas(respuesta);
            }
        }
        test.setPreguntas(preguntas);
        return editDescription(test);
    }

    public Test editDescription(Test test) {
        test.setDescription(obtenerResultados(test.getIdTest()));
        return testRepository.save(test);
    }

    @Override
    public Test desactivarTets(Integer id){
        Test test=getTestById(id);
        test.setActivate(false);
        return testRepository.save(test);
    }


    @Override
    public List<Test> ObtenerTestbyUser(String username) {
        return testRepository.getTestByUser(username);
    }

    @Override
    public String obtenerResultados(Integer id) {
        String perfil="Tu perfil es de ser ";
        Test test=getTestById(id);
        List<Carrera> carreras=carrerasRelacionadas(test);
        perfil=perfil+carreras.get(carreras.size()-1).getPerfil();
        return perfil;
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
    public List<Carrera> carrerasRelacionadas(Integer id){
        Test test=getTestById(id);
        return carrerasRelacionadas(test);
    }


    public List<Carrera> carrerasRelacionadas(Test test) {
        HashMap<Carrera,Integer>mapa=HashResults(test);
        List<Carrera> carreras= new ArrayList<>();
        int values[]= new int[mapa.size()];
        int count=0;
        for ( Integer i : mapa.values()){
            values[count]=i;
            count=count+1;
        }
        int aux;
        for(int i=0;i<values.length;i++){
            for(int j=0;j<values.length-1;j++){
                if(values[j]>values[j+1]){
                    aux=values[j];
                    values[j]=values[j+1];
                    values[j+1]=aux;
                }
            }
        }
        for(Integer i :values){
            for(Carrera carrera : mapa.keySet()){
                Integer f=mapa.get(carrera);
                if(i==f){
                    carreras.add(carrera);
                }
            }
        }
        return carreras;
    }


    public void deleteTest(Integer IdTest){
            testRepository.deleteById(IdTest);
    }

}
