package com.example.edelec.entitys;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Comentario")


public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "Fecha", nullable = false)
    private Date tiempo;

    @NotBlank
    @Size(min = 1, message = "Este mensaje esta vacio")
    @Column(name = "contenido", nullable = false)
    private String contenido;

    public void setComentarioId(Long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
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
