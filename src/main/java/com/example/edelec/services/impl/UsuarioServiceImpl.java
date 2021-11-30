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


    @Override
    public Usuario getUsuarioById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(new Usuario());
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Integer IdUsuario){
        usuarioRepository.deleteById(IdUsuario);
    }

    public  Usuario getUsuarioByUser(String user){
        return usuarioRepository.getByUser(user);
    }

    public List<Usuario> getUsuarioByName(String nombre){
         return usuarioRepository.getAllByName(nombre);
    }

    public Integer Login(Usuario usuario) {
        return 0;
    }
}
