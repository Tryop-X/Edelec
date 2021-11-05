package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "comentarios")
@NoArgsConstructor
@AllArgsConstructor

public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "Fechas", nullable = false)
    private LocalDateTime tiempo;

    @NotNull
    @NotBlank
    @Size(min = 1, message = "Este mensaje esta vacio")
    @Column(name = "contenidos", nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idUsuarios",nullable = false,  foreignKey = @ForeignKey(name = "FK_Usuario_Comentario"))
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "idUniversidades",nullable = false,  foreignKey = @ForeignKey(name = "FK_Universidada_Comentario"))
    private Universidad universidad;

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
}
