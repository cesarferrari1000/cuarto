package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor,Long> {
}
