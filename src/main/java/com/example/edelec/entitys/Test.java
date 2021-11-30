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
import java.util.List;

@Entity
@Table(name = "tests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTest;

    @NotNull
    @Size(min = 20)
    @Column(name = "descripciónes", nullable = true, length = 20, unique = true)
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "fechas", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario",nullable = false,  foreignKey = @ForeignKey(name = "FK_Test_Usuario"))
    private Usuario usuario;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Pregunta> preguntas;
}
