package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "sedes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;

    @NotNull
    @Size(min = 5, max = 20, message = "Ciudad no valido")
    @Column(name = "Ubicacion", nullable = false)
    private String Ubicacion;

    @NotNull
    @Size(min = 5, max = 20, message = "Departamento no valido")
    @Column(name = "Departamento", nullable = false)
    private String Direccion;

    @ManyToOne
    @JoinColumn(name = "id_universidad",nullable = false,  foreignKey = @ForeignKey(name = "FK_Sede_Universidad"))
    private Universidad universidad;

}
