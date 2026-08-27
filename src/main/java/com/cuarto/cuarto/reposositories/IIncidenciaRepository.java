package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncidenciaRepository extends JpaRepository<Incidencia,Long> {
}
