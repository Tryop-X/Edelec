package com.example.edelec.controllers;

import com.example.edelec.entitys.Usuario;
import com.example.edelec.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioNew =usuarioService.createUsuario(usuario);
        return  new ResponseEntity<Usuario>(usuarioNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario() {
        List<Usuario> usuario =usuarioService.getAllUsuario();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario") String idUsuario) {
        Usuario usuario =usuarioService.getUsuarioById(idUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioActualizar =usuarioService.updateUsuario(usuario);
        return new ResponseEntity<>(usuarioActualizar, HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("idUsuario") Integer idUsuario){
        usuarioService.deleteUsuario(idUsuario);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
