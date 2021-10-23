package com.example.edelec.services;
import com.example.edelec.entitys.Carrera;

import java.util.List;

public interface CarreraService {
<<<<<<< HEAD
    Carrera createsCarrera(Carrera carrera);
    /*List<Carrera>*/

=======
   Carrera createCarrera(Carrera carrera);
    List<Carrera> getAllCarrera();
    Carrera getCarreraById(Long IdCarrera);

   Carrera updateCarrera(Carrera carrera);
    void deleteCarrera(Long restaurantId);
>>>>>>> a12fa5675f3614a4d4f59a67db95bd404f6016c3
}
