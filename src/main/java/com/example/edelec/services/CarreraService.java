package com.example.edelec.services;
import com.example.edelec.entitys.Carrera;

import java.util.List;

public interface CarreraService {
   Carrera createCarrera(Carrera carrera);
    List<Carrera> getAllCarrera();
    Carrera getCarreraById(Long IdCarrera);

   Carrera updateCarrera(Carrera carrera);
    void deleteCarrera(Long restaurantId);
}
