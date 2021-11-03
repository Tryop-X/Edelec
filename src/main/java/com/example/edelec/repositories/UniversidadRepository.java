package com.example.edelec.repositories;

import com.example.edelec.entitys.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer> {

    @Query("SELECT u FROM  Universidad u WHERE u.Name=:name")
    Universidad buscarUniversidad(@Param("name") String name);

    @Query("SELECT u.Name from Universidad u inner JOIN u.sede b where b.Dsitrito=:busqueda")
    List<Object> buscarPorDistrito(@Param("busqueda") String busqueda);

    @Query("SELECT u.Name from Universidad u inner JOIN u.sede b where b.ciudad=:busqueda")
    List<Object> buscarPorCiudad(@Param("busqueda") String busqueda);

}
