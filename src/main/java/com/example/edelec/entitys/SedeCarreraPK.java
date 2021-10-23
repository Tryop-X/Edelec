package com.example.edelec.entitys;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class SedeCarreraPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_Sede", nullable = false)
    private Sede idSede;

    @ManyToOne
    @JoinColumn(name="id_Carrera", nullable = false)
    private Carrera IdCarrera;
}
