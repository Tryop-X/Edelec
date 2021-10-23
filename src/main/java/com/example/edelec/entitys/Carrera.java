package com.example.edelec.entitys;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCarrera;

    @Column(name = "nombreCarrera")
    String nombreCarrera;

    String descripcionUniversidad;
    int tasadeEmpleabilidad;
    float salarioPromedio;




}
