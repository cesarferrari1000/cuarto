package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.Alumno;
import com.cuarto.cuarto.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor,Long> {
    Optional<Profesor> findTopByOrderByIdProfesorDesc();
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCaseAndIdProfesorNot(String email, Long idProfesor);
}
