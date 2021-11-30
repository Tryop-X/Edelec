package com.example.edelec.repositories;

import com.example.edelec.entitys.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {
    @Query("select t FROM  Test t WHERE t.idTest=:idTest")
        Test getById(@Param("idTest") String idTest);

    @Query("select t FROM  Test t WHERE t.description=:description")
    Test save(@Param("description") String description);

    @Query("select t FROM  Test t WHERE t.idTest=:idTest")
    List<Test> getAllByIdTest(@Param("nombre") String idTest);



}
