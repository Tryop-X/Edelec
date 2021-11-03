package com.example.edelec.services;

import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Universidad;

import java.util.List;

public interface UniversidadService {

    Universidad createUniversidad(Universidad universidad);
    List<Universidad> getAllUniversidad();
    Universidad getUniversidadByname(String name);
    List<Object> getUniversidadByDsitrito(String distrito);
    List<Object> getUniversidadByCiudad(String ciudad);

    Universidad updateUniversidad(Universidad universidad);
    void deleteUniversidad(String name);
}
