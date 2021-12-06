package com.example.edelec.services;

import com.example.edelec.entitys.Egresado;
import com.example.edelec.entitys.Sede;

import java.util.List;

public interface SedeService {

    Sede createEgresado(Sede sede);
    List<Sede> getAllEgresado();
    List<Sede> getEgresadoUniversidadCarrera(String name);
    Egresado updateEgresado(Sede sede);
    void deleteEgresado(Integer IdSede);
}
