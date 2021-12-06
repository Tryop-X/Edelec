package com.example.edelec.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "respuestas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRespuesta;

    @Column(name = "contenidosRespuestas", nullable = false)
    private String contenidoRespuesta;

    @Column(name = "Selacionado", nullable = false)
    private Boolean select;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idPregunta",nullable = false,  foreignKey = @ForeignKey(name = "FK_Respuesta_Pregunta"))
    private Pregunta pregunta;
}
