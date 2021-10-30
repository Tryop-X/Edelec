package com.example.edelec.entitys;


import javax.persistence.*;

@Entity
@Table(name = "sedes_carreras")
@IdClass(SedeCarreraPK.class)

public class SedeCarrera{
    @Id
    private Sede idSede;

    @Id
    private Carrera IdCarrera;

    @Column(name = "Malla", nullable = true)
    private String mallasUniversitarias;//Noes string es una imagen
    @Column(name = "precio", nullable = false)
    private float precio;



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
