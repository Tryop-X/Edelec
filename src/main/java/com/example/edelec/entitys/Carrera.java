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
    private Integer idCarrera;


    @NotNull
    @Size(min = 5,max = 30)
    @Column(name = "nombres", nullable = false, unique = true)
    private String nombreCarrera;

    @NotNull
    @Size(min = 10, max = 300)
    @Column(name = "descripciones", nullable = false, unique = true)
    private String descripcionDeCarrera;

    @NotNull
    @Column(name = "tasasDeEmpleabilidad", nullable = false)
    private Float tasaDeEmpleabilidad;

    @NotNull
    @Column(name = "salariosPromedios", nullable = false)
    private Integer salarioPromedio;


    public Integer getidCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        idCarrera = idCarrera;
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
