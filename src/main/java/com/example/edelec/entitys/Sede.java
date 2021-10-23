package com.example.edelec.entitys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Sede")

public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;

    @NotNull
    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "Dsitrito", nullable = false)
    private Long Dsitrito;

    @NotNull
    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "Ciudad", nullable = false)
    private String ciudad;

    @NotNull
    @Size(min = 5, max = 20, message = "Departamento no valido")
    @Column(name = "Departamento", nullable = false)
    private String Departamento;

    @ManyToOne
    @JoinColumn(name = "id_universidad",nullable = false,  foreignKey = @ForeignKey(name = "FK_Sede_Universidad"))
    private Universidad universidad;



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


    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }
}
