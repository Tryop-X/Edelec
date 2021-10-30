package com.example.edelec.entitys;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotNull
    @Size(min = 6, max = 30, message = "Nombre no valido")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 6, max = 30, message = "Nombre no valido")
    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @NotNull
    @Email
    @Column(name = "Correo", nullable = false)
    private String correo;

    @NotNull
    @Size(min = 8,max = 16, message = "Contraseña no valida")
    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @OneToMany(mappedBy = "User",cascade ={CascadeType.ALL})
    private List<Comentario> coment;

    public String getNombre() {
        return nombre;
    }

    public void setNombredeUsuario(String nombredeUsuario) {
        this.nombre = nombredeUsuario;
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
