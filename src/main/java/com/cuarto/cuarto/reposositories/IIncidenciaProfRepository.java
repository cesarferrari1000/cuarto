package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.IncidenciaProf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncidenciaProfRepository extends JpaRepository<IncidenciaProf,Long> {
}
