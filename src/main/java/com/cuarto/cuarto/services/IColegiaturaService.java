package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Colegiatura;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IColegiaturaService {

    List<Colegiatura> listColegiatura();
    Optional<Colegiatura> colegiaturaFindById(Long id);
    Colegiatura insertColegiatura(Colegiatura col);
    Colegiatura updateColegiatura(Colegiatura col,Long idCol);
    Boolean deleteColegiatura(Long idDelete);
    List<Colegiatura> listByMatriculaAndFecha(String matricula, Date fechaInicio, Date fechaFin);
    List<Colegiatura>ListfindByFechaBetween(Date fechaInicio,Date FechaFin);
}
