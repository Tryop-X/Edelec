package com.example.edelec.services;


import com.example.edelec.entitys.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario);

  Usuario getUsuarioById(String IdUsuario);

    Usuario updateUsuario(Usuario usuario);
    List<Usuario> getAllUsuario();

}
