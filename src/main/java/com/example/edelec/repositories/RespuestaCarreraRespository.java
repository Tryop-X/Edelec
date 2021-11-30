package com.example.edelec.repositories;

import com.example.edelec.entitys.RespuestaCarrera;
import com.example.edelec.entitys.RespuestaCarreraPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaCarreraRespository extends JpaRepository<RespuestaCarrera, RespuestaCarreraPK> {


}
