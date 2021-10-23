package com.example.edelec.repositories;

import com.example.edelec.entitys.Carrera;
import com.example.edelec.entitys.Universidad;
import com.example.edelec.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Universidad, Long> {

    @Query("FROM  Usuario u WHERE u.nombre=:nombre")
    List<Usuario> buscarnombredeUsuario(String nombre);

    @Query("FROM Usuario u WHERE u.apellido=:apellido")
    List<Usuario>buscarapellidodeUsuario(String apellido);

    @Query("FROM  Usuario u WHERE u.correo=:corrreo")
    List<Usuario> buscarcorreodeUsuario(String correo);

    @Query("FROM  Usuario u WHERE u.contraseña=:contraseña")
    List<Usuario> buscarcontraseñadeUsuario(String contraseña);
}
