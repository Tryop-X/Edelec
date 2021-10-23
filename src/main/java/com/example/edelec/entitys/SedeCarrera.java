package com.example.edelec.entitys;


import javax.persistence.*;

@Entity
@Table(name = "SedeCarrera")

public class SedeCarrera{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String mallasUniversitarias;//Noes string es una imagen
    float precio;



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

    public Long getId() {
        return id;
    }




}
