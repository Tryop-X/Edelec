package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "preguntas")
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    private String pregunta;

    private Integer point;


}
