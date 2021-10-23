package com.example.edelec.entitys;


<<<<<<< HEAD
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Carrera")

public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdCarrera;


    @NotNull
    @Column(name = "nombre", nullable = false , unique = true)
    private String nombreCarrera;

    @NotNull
    @Size(min = 10)
    @Column(name = "descripcion", nullable = false, unique = true)
    private String descripcionDeCarrera;

    @NotNull
    @Column(name = "tasaDeEmpleabilidad", nullable = false)
    private int tasadeEmpleabilidad;

    @Column(name = "salarioPromedio", nullable = false)
    private float salarioPromedio;

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getDescripcionUniversidad() {
        return descripcionDeCarrera;
    }

    public void setDescripcionUniversidad(String descripcionUniversidad) {
        this.descripcionDeCarrera = descripcionUniversidad;
    }

    public int getTasadeEmpleabilidad() {
        return tasadeEmpleabilidad;
    }

    public void setTasadeEmpleabilidad(int tasadeEmpleabilidad) {
        this.tasadeEmpleabilidad = tasadeEmpleabilidad;
    }

    public float getSalarioPromedio() {
        return salarioPromedio;
    }

    public void setSalarioPromedio(float salarioPromedio) {
        this.salarioPromedio = salarioPromedio;
    }

    public int getCarId() {
        return IdCarrera;
    }
=======
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



>>>>>>> a12fa5675f3614a4d4f59a67db95bd404f6016c3

}
