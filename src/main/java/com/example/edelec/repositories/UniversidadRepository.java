package com.example.edelec.repositories;

import com.example.edelec.entitys.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {
    @Query("FROM  Universidad u WHERE u.Name=:name")
    List<Universidad> buscarUniversidad(String name);
}
