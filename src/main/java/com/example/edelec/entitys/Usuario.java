package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Size()
    @Column(name = "nombre", nullable = false)
    private String nombredeUsuario;


    @Column(name = "Apellido", nullable = false)
    private String apellido;


    @Column(name = "Correo", nullable = false)
    private String correo;


    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    public String getNombredeUsuario() {
        return nombredeUsuario;
    }

    public void setNombredeUsuario(String nombredeUsuario) {
        this.nombredeUsuario = nombredeUsuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
