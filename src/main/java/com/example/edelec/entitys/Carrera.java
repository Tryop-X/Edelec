package com.example.edelec.entitys;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "carreras")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdCarrera;


    @NotNull
    @Size(min = 5,max = 30)
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombreCarrera;

    @NotNull
    @Size(min = 10, max = 300)
    @Column(name = "descripcion", nullable = false, unique = true)
    private String descripcionDeCarrera;

    @NotNull
    @Column(name = "tasaDeEmpleabilidad", nullable = false)
    private Float tasaDeEmpleabilidad;

    @NotNull
    @Column(name = "salarioPromedio", nullable = false)
    private Integer salarioPromedio;
}
