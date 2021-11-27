package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "perfiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerfil;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "fechas", nullable = false)
    private LocalDateTime fecha;

    @NotNull
    @Size(min = 20)
    @Column(name = "descripciónes", nullable = true, length = 20, unique = true)
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "usuarios", foreignKey = @ForeignKey(name = "FK_Usuario_Perfil"))
    private Usuario usuario;

}
