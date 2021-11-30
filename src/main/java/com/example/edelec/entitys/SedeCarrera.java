package com.example.edelec.entitys;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sedes_carreras")
@IdClass(SedeCarreraPK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SedeCarrera{
    @Id
    private Sede idSede;

    @Id
    private Carrera idCarrera;

    @Column(name = "mallas", nullable = true)
    private String mallasUniversitarias;//Noes string es una imagen

    @Column(name = "precios", nullable = false)
    private float precio;

}
