package com.example.edelec.services.impl;

import com.example.edelec.entitys.Respuesta;
import com.example.edelec.exception.ResourceNotFoundException;
import com.example.edelec.repositories.RespuestaRepository;
import com.example.edelec.services.RespuestaService;
import com.example.edelec.validation.RespuestaValidator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    private RespuestaRepository respuestaRepository;

    public RespuestaServiceImpl(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    @Override
    public Respuesta createRespuestas(Respuesta respuesta) {
        RespuestaValidator.validate(respuesta);
        return respuestaRepository.save(respuesta);
    }

    @Override
    public Respuesta getRespuesta(Integer id) {
        return respuestaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No Existe respuesta: "+id));
    }

    @Override
    public Respuesta createRespuestaBase(Respuesta respuesta) {
        RespuestaValidator.validateBase(respuesta);
        return respuestaRepository.save(respuesta);
    }

    @Override
    public List<Respuesta> listarRespuestas() {
        return respuestaRepository.findAll();
    }

    @Override
    public  void deleteRespuesta(Integer idRespuesta){
        respuestaRepository.deleteById(idRespuesta);
    }
}
