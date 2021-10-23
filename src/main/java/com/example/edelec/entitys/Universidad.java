package com.example.edelec.entitys;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Universidad")
public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUniversidad;

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


    @OneToMany(mappedBy = "universidad",cascade ={CascadeType.ALL})
    private List<Sede> sede;

    @OneToMany(mappedBy = "universidad",cascade ={CascadeType.ALL})
    private List<Comentario> coments;



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

}