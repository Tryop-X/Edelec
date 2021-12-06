package com.example.edelec.entitys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "egresado")
@Setter
@Getter

public class Egresado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEgresado;

    @NotNull
    @Column(name = "nombre_egresado")
    private String nombreEgresado;

    @ManyToOne
    @JoinColumn(name="id_sede_carrera", nullable = false, foreignKey = @ForeignKey(name="fk_sede_carrera"))
    private SedeCarrera sedeCarrera;

    @NotNull
    @Column(name = "curriculum")
    private String curriculum;  

    @Column(name = "foto_egresado")
    private String fotoEgresado;

}
