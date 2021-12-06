package com.example.edelec.entitys;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class RespuestaCarreraPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="idRespuesta", nullable = false)
    private Respuesta idRespuesta;

    @ManyToOne
    @JoinColumn(name="idCarrera", nullable = false)
    private Carrera idCarrera;
}
