package com.example.edelec.repositories;

import com.example.edelec.entitys.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Query("FROM  Carrera u WHERE u.nombreCarrera=:nombre")
    List<Carrera> buscarCarrera(@Param("nombre") String nombreCarrera);

    @Query("FROM Carrera u WHERE u.descripcionDeCarrera=:name")
    List<Carrera> BuscarDescripcionCarrera(@Param("name") String name);

    @Query("FROM  Carrera u WHERE u.salarioPromedio=:name")
    List<Carrera> buscarCarreraporSalario(@Param("name") String name);

    @Query("FROM Carrera u WHERE u.tasaDeEmpleabilidad=:name")
    List<Carrera> BuscarPorTasa(@Param("name") String name);
}
