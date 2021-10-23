package com.example.edelec.entitys;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Carrera")

public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCarrera;


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

    public Long getIdCarrera() {
        return IdCarrera;
    }

}
