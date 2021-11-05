package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "perfiles")
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;

}
