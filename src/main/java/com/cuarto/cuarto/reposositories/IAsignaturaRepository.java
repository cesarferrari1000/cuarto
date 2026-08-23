package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsignaturaRepository extends JpaRepository< Asignatura,Long> {
}
