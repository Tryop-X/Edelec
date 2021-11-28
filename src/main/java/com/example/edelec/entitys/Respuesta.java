package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "respuesatas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRespuesta;

    @Column(name = "contenidos_pregunta", nullable = false)
    private String contenido_pregunta;

    @ManyToOne
    @JoinColumn(name = "idPregunta",nullable = false,  foreignKey = @ForeignKey(name = "FK_Respuesta_Pregunta"))
    private Respuesta pregunta;
}
