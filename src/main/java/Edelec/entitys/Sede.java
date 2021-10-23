package Edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Carrera")
public class Sede {
    @Id
    @Column(name = "id_sede", nullable = false)
    private Long idSede;
    String ciudad;
    String distrito;




    public Long getIdSede() {
        return idSede;
    }


}
