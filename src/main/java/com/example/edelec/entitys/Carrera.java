package com.example.edelec.entitys;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "carreras")
@NoArgsConstructor
@AllArgsConstructor

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


    public Integer getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        IdCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getDescripcionDeCarrera() {
        return descripcionDeCarrera;
    }

    public void setDescripcionDeCarrera(String descripcionDeCarrera) {
        this.descripcionDeCarrera = descripcionDeCarrera;
    }

    public Float getTasaDeEmpleabilidad() {
        return tasaDeEmpleabilidad;
    }

    public void setTasaDeEmpleabilidad(Float tasaDeEmpleabilidad) {
        this.tasaDeEmpleabilidad = tasaDeEmpleabilidad;
    }

    public Integer getSalarioPromedio() {
        return salarioPromedio;
    }

    public void setSalarioPromedio(Integer salarioPromedio) {
        this.salarioPromedio = salarioPromedio;
    }
}
