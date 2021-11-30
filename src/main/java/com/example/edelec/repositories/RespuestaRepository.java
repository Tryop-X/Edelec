package com.example.edelec.repositories;

import com.example.edelec.entitys.Respuesta;
import com.example.edelec.entitys.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {

    @Query("SELECT r FROM  Respuesta r WHERE r.contenidoRespuesta=:name")
    Universidad buscarUniversidad(@Param("name") String name);
}
