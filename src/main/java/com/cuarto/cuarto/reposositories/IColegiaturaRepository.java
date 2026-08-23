package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.Colegiatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColegiaturaRepository extends JpaRepository<Colegiatura,Long> {
}
