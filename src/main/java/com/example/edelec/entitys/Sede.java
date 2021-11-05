package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "sedes")
@NoArgsConstructor
@AllArgsConstructor

public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSede;

    @NotNull
    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "distritos", nullable = false)
    private Long distrito;

    @NotNull
    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "ciudades", nullable = false)
    private String ciudad;

    @NotNull
    @Size(min = 5, max = 20, message = "Departamento no valido")
    @Column(name = "departamentos", nullable = false)
    private String departamento;

    @ManyToOne
    @JoinColumn(name = "idUniversidad",nullable = false,  foreignKey = @ForeignKey(name = "FK_Sede_Universidad"))
    private Universidad universidad;

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public Long getDistrito() {
        return distrito;
    }

    public void setDistrito(Long distrito) {
        this.distrito = distrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
}
