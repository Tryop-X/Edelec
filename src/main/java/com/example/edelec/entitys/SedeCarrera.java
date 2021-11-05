package com.example.edelec.entitys;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sedes_carreras")
@IdClass(SedeCarreraPK.class)
@NoArgsConstructor
@AllArgsConstructor
public class SedeCarrera{
    @Id
    private Sede idSede;

    @Id
    private Carrera idCarrera;

    @Column(name = "mallas", nullable = true)
    private String mallasUniversitarias;//Noes string es una imagen

    @Column(name = "precios", nullable = false)
    private float precio;


    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getMallasUniversitarias() {
        return mallasUniversitarias;
    }

    public void setMallasUniversitarias(String mallasUniversitarias) {
        this.mallasUniversitarias = mallasUniversitarias;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
