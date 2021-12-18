package com.example.edelec.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "plantillas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Plantilla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlantillas;


    @Column(name = "activado")
    private Boolean activate;

    @OneToMany(mappedBy = "plantilla")
    private List<Pregunta> preguntas;
}
