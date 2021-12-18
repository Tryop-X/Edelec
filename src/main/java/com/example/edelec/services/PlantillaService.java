package com.example.edelec.services;


import com.example.edelec.entitys.Plantilla;

import java.util.List;

public interface PlantillaService {
    Plantilla createPlatilla(Plantilla plantilla);
    Plantilla getPlantillaActual();
    Plantilla getPlantillaById(Integer id);
    Plantilla activarPlantilla(Integer id);
    List<Plantilla> listarPlantillas();
    void deletePlatilla(Integer id);
    Plantilla editPlantilla(Plantilla plantilla, Integer id);
}
