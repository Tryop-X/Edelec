package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Sede")

public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;

    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "Dsitrito", nullable = false)
    private Long Dsitrito;


    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "Ciudad", nullable = false)
    private String ciudad;

    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "Distrtito", nullable = false)
    private String distrito;

    public Long getDsitrito() {
        return Dsitrito;
    }

    public void setDsitrito(Long dsitrito) {
        Dsitrito = dsitrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Long getIdSede() {
        return idSede;
    }

}
