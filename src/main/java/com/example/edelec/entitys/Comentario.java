package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comentario")

public class Comentario {
    @Id
    @Column(name = "comentario_id", nullable = false)
    private Long comentarioId;
    Date tiempo;
    String contenido;

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
