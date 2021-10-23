package Edelec.entitys;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Carrera")
public class Carrera {
    @Id
    @Column(name = "carid", nullable = false)
    private Long carId;
    String nombreCarrera;
    String descripcionUniversidad;
    int tasadeEmpleabilidad;
    float salarioPromedio;


    public void setCarId(Long carid) {
        this.carId = carid;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getDescripcionUniversidad() {
        return descripcionUniversidad;
    }

    public void setDescripcionUniversidad(String descripcionUniversidad) {
        this.descripcionUniversidad = descripcionUniversidad;
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

    public Long getCarId() {
        return carId;
    }

}
