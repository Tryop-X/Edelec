package com.example.edelec.entitys;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Comentario")


public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "Fecha", nullable = false)
    private LocalDateTime tiempo;

    @NotNull
    @NotBlank
    @Size(min = 1, message = "Este mensaje esta vacio")
    @Column(name = "contenido", nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false,  foreignKey = @ForeignKey(name = "FK_Usuario_Comentario"))
    private Usuario User;

    @ManyToOne
    @JoinColumn(name = "id_universidad",nullable = false,  foreignKey = @ForeignKey(name = "FK_Universidada_Comentario"))
    private Universidad universidad;

    public void setComentarioId(Long comentarioId) {
        this.comentarioId = comentarioId;
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

    public Long getComentarioId() {
        return comentarioId;
    }


}
