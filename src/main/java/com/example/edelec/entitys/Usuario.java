package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
>>>>>>> a12fa5675f3614a4d4f59a67db95bd404f6016c3
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
<<<<<<< HEAD
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
=======
    @Column(name = "id", nullable = false)
    private Long id;
    String nombredeUsuario;
    String apellido;
    String correo;
    String contraseña;

    public String getNombredeUsuario() {
        return nombredeUsuario;
    }

    public void setNombredeUsuario(String nombredeUsuario) {
        this.nombredeUsuario = nombredeUsuario;
>>>>>>> a12fa5675f3614a4d4f59a67db95bd404f6016c3
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
<<<<<<< HEAD
=======

    public Long getId() {
        return id;
    }


>>>>>>> a12fa5675f3614a4d4f59a67db95bd404f6016c3
}