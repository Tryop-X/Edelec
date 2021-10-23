package Edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.websocket.Decoder;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SedeCarrera extends Carrera {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    String mallasUniversitarias;//Noes string es una imagen
    float precio;



    public String getMallasUniversitarias() {
        return mallasUniversitarias;
    }

    public void setMallasUniversitarias(String mallasUniversitarias) {
        this.mallasUniversitarias = mallasUniversitarias;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }




}
