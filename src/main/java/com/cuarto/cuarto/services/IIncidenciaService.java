package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Incidencia;
import com.cuarto.cuarto.modelo.IncidenciaAl;

import java.util.List;

public interface IIncidenciaService {


    List<Incidencia> listaIncidenciaAl();
    Incidencia incFindById(Long idInc);
    Incidencia insertInc(Incidencia incAl);
    Incidencia updateInc(Incidencia incidencia,Long idInc);
    boolean deleteInc(Long idInc);
}
