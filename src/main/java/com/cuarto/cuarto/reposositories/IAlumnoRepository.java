package com.cuarto.cuarto.reposositories;


import com.cuarto.cuarto.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno,Long> {

}
