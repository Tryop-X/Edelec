package com.example.edelec.repositories;

import com.example.edelec.entitys.Plantilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantillaRepository extends JpaRepository<Plantilla, Integer> {

    @Query("SELECT p FROM Plantilla p WHERE p.activate=true")
    Plantilla BuscarPlantillaActual();

    @Query("SELECT p FROM Plantilla p WHERE p.idPlantillas=:id")
    Plantilla BuscarById(@Param("id")Integer id);

}
