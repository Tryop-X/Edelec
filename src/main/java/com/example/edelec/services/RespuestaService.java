package com.example.edelec.services;


import com.example.edelec.entitys.Respuesta;

import java.util.List;

public interface RespuestaService {

    Respuesta createRespuestas(Respuesta respuesta);
    Respuesta getRespuesta(Integer id);
    Respuesta createRespuestaBase(Respuesta respuesta);
    List<Respuesta> listarRespuestas();
    void deleteRespuesta(Integer idRespuesta);
}
