package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Profesor;

import java.util.List;

public interface IProfesorService {


    List<Profesor> ListaProfesor();
    Profesor buscaProfesor(Long matricula);
    Profesor insertaProfesor(Profesor profesor);
    Profesor editProfesor(Long id,Profesor profesor);
}
