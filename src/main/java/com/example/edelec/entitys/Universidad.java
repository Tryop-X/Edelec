package com.example.edelec.entitys;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "universidades")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniversidad;

    @NotNull
    @Size(min = 10 , max = 50 , message = "El nombre es muy pqueño")
    @Column(name = "Univerdidad", nullable = false, length = 20, unique = true)
    private String Name;

    @NotNull
    @Size(min = 20)
    @Column(name = "descripción", nullable = true, length = 20, unique = true)
    private String description;

    @Column(name = "imagen", nullable = true)
    private String image;

    @NotNull
    @Column(name = "tipo_gestion")
    private String tipoGestion;

    @OneToMany(mappedBy = "universidad",cascade ={CascadeType.ALL})
    private List<Sede> sede;

    @OneToMany(mappedBy = "universidad",cascade ={CascadeType.ALL})
    private List<Comentario> coments;


    public Integer getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Sede> getSede() {
        return sede;
    }

    public void setSede(List<Sede> sede) {
        this.sede = sede;
    }

    public List<Comentario> getComents() {
        return coments;
    }

    public void setComents(List<Comentario> coments) {
        this.coments = coments;
    }

}
