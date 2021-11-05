package com.example.edelec.services.impl;

import com.example.edelec.entitys.Usuario;

import com.example.edelec.repositories.UsuarioRepository;
import com.example.edelec.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //esta para revision
    @Override
    public Usuario getUsuarioById(String idUsuario) {
        return usuarioRepository.getById(idUsuario);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }






    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }




}
