package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.IncidenciaAl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncidenciaAlRepository extends JpaRepository<IncidenciaAl,Long> {
}
