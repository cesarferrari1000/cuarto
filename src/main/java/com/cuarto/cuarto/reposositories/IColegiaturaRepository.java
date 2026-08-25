package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.Colegiatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IColegiaturaRepository extends JpaRepository<Colegiatura,Long> {
    List<Colegiatura> findByAlumno_MatriculaAndFechaBetween(
            String matricula, Date fechaInicio, Date fechaFin);
    List<Colegiatura> findByFechaBetween(
             Date fechaInicio, Date fechaFin);
}
