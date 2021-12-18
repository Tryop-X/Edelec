package com.example.edelec.controllers;

import com.example.edelec.entitys.Usuario;
import com.example.edelec.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }





    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNew =usuarioService.createUsuario(usuario);
        return  new ResponseEntity<Usuario>(usuarioNew, HttpStatus.CREATED);
    }

}
