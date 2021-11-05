package com.example.edelec.entitys;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class PerfilCarreraPK implements Serializable {
    @ManyToOne
    @JoinColumn(name ="idPerfil", nullable = false)
    private Perfil idPerfil;

    @ManyToOne
    @JoinColumn(name ="idCarrera", nullable = false)
    private  Carrera idCarrera;
}
