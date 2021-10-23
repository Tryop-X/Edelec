package com.example.edelec.repositories;

import com.example.edelec.entitys.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

=======
import org.springframework.stereotype.Repository;

import java.util.Optional;

>>>>>>> a12fa5675f3614a4d4f59a67db95bd404f6016c3
@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

}
