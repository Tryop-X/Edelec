package com.example.edelec.repositories;

import com.example.edelec.entitys.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {
    @Query("FROM  Universidad u WHERE u.Name=:name")
    List<Universidad> buscarUniversidad(@Param("name") String name);

    @Query("select distinct u from Universidad u inner JOIN u.sede b where b.Dsitrito=:busqueda")
    List<Object[]> buscarPorDepartamento(@Param("busqueda") String busqueda);

    @Query("select distinct u from Universidad u inner JOIN u.sede b where b.ciudad=:busqueda")
    List<Object[]> buscarPorCiudad(@Param("busqueda") String busqueda);

}
