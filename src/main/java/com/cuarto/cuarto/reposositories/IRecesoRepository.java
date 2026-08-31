package com.cuarto.cuarto.reposositories;


import com.cuarto.cuarto.modelo.Receso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecesoRepository extends JpaRepository<Receso,Long> {}



