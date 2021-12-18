package com.example.edelec.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
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

    @Column(name = "contenidos")
    private String contenido;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idTest",  foreignKey = @ForeignKey(name = "FK_Pregunta_Test"))
    private Test test;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idPlantilla",  foreignKey = @ForeignKey(name = "FK_Pregunta_Plantilla"))
    private Plantilla plantilla;


    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.REMOVE)
    private List<Respuesta> respuesta;
}
