package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Asignatura;

import java.util.List;

public interface IAsignaturaService {



    List<Asignatura> buscarAsignatura();
    Asignatura asignaturaFindById(Long id);
    Asignatura insertAsignatura(Asignatura asignatura);
    Asignatura updateAsignatura(Long id,Asignatura asignatura);
    boolean asignaturaDelete(Long id);
}
