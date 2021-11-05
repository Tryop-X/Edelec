package com.example.edelec.repositories;

import com.example.edelec.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u FROM  Usuario u WHERE u.nombre=:nombre")
    List<Usuario> buscarnombredeUsuario(@Param("nombre") String nombre);

    @Query("select u FROM Usuario u WHERE u.apellido=:apellido")
    List<Usuario>buscarapellidodeUsuario(@Param("apellido")String apellido);

    @Query("select u FROM  Usuario u WHERE u.correo=:correo")
    List<Usuario> buscarcorreodeUsuario(@Param("correo")String correo);

    @Query("select u FROM  Usuario u WHERE u.idUsuario=:id")
    Usuario getById(@Param("id")String idUsuario);



}
