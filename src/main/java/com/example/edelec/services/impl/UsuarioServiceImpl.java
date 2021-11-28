package com.example.edelec.services.impl;

import com.example.edelec.entitys.Usuario;

import com.example.edelec.repositories.UsuarioRepository;
import com.example.edelec.services.UsuarioService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final static String USER_NO_FOUND_MSG =
            "Tu e-mail %s no funciona";
    private final UsuarioRepository usuarioRepository;


    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


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

    public void deleteUsuario(Integer IdUsuario){
        usuarioRepository.deleteById(IdUsuario);
    }

    public List<Usuario> getUsuarioByName(String nombre){
         return usuarioRepository.getAllByName(nombre);
    }

    public Integer Login(Usuario usuario){
        Usuario usuarioTemp = usuarioRepository.getByUser(usuario.getUsername());
        if (usuarioTemp!=null){
            if (usuario.getPassword().equals(usuarioTemp.getPassword())) {
                return 1;
            }
            else{
                return -1;
            }
        }
        return 0;
    }


    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return usuarioRepository.findByCorreo(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(USER_NO_FOUND_MSG,email)));
    }
}
