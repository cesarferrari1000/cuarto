package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Colegiatura;

import java.util.List;
import java.util.Optional;

public interface IColegiaturaService {

    List<Colegiatura> listColegiatura();
    Optional<Colegiatura> colegiaturaFindById(Long id);
    Colegiatura insertColegiatura(Colegiatura col);
    Colegiatura updateColegiatura(Colegiatura col,Long idCol);
    Boolean deleteColegiatura(Long idDelete);
}
