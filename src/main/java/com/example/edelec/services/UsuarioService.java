package com.example.edelec.services;


import com.example.edelec.entitys.Usuario;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {

    Usuario createUsuario(Usuario usuario);
    Usuario getUsuarioById(String IdUsuario);
    List<Usuario> getUsuarioByName(String nombre);
    Integer Login(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);
    List<Usuario> getAllUsuario();
    void deleteUsuario(Integer IdCarrera);


}
