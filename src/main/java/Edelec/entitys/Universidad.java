package Edelec.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Universidad")
public class Universidad {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniversidad;

    @NotNull
    @Size(min = 10 , max = 50 , message = "El nombre es muy pqueño")
    @Column(name = "Univerdidad", nullable = false, length = 20, unique = true)
    private String Name;

    @Size(min = 20 , max = 200)
    @Column(name = "descripción", nullable = true, length = 20, unique = true)
    private String description;

    @Column(name = "imagen", nullable = true)
    private String image;


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
