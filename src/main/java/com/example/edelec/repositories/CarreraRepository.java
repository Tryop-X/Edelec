package com.example.edelec.repositories;

import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query("FROM  Carrera u WHERE u.nombreCarrera=:nombre")
    List<Carrera> buscarCarrera(Param("nombre") String nombre);

    @Query("FROM Carrera u WHERE u.descripcionDeCarrera=:name")
    List<Carrera> BuscarDescripcionCarrera(Param("name") String name);

    @Query("FROM  Carrera u WHERE u.salarioPromedio=:name")
    List<Carrera> buscarCarreraporSalario(Param("name") String name);

    @Query("FROM Carrera u WHERE u.tasadeEmpleabilidad=:name")
    List<Carrera> BuscarPorTasa(Param("name") String name);
}
