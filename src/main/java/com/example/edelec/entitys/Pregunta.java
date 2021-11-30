package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.List;

@Entity
@Table(name = "preguntas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    @Column(name = "contenidos", nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idTest",nullable = false,  foreignKey = @ForeignKey(name = "FK_Pregunta_Test"))
    private Test test;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<Respuesta> respuesta;
}
