package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "RespuestasCarreras")
@IdClass(RespuestaCarreraPK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RespuestaCarrera {
    @Id
    private Respuesta idRespuesta;

    @Id
    private Carrera idCarrera;
}
