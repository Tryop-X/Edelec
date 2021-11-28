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
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioNew =usuarioService.createUsuario(usuario);
        return  new ResponseEntity<Usuario>(usuarioNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario() {
        List<Usuario> usuario =usuarioService.getAllUsuario();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }


    @GetMapping("/id/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario") Integer idUsuario) {
        Usuario usuario =usuarioService.getUsuarioById(idUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<Usuario> getUsuarioByUser(@PathVariable("user") String user) {
        Usuario usuario =usuarioService.getUsuarioByUser(user);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/name/{idUsuario}")
    public ResponseEntity<List<Usuario>> getUsuarioByname(@PathVariable("idUsuario") String Name) {
        List<Usuario> usuario =usuarioService.getUsuarioByName(Name);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<Integer> login(@RequestBody Usuario usuario) {
        Integer integer=usuarioService.Login(usuario);
        return new ResponseEntity<>(integer,HttpStatus.OK);
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
