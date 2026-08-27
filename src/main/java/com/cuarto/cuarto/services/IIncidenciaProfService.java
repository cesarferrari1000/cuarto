package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.IncidenciaAl;
import com.cuarto.cuarto.modelo.IncidenciaProf;

import java.util.List;

public interface IIncidenciaProfService {


    List<IncidenciaProf> listaIncidenciaProf();
    IncidenciaProf incFindById(Long idInc);
    IncidenciaProf insertInc(IncidenciaProf incAl);
    IncidenciaProf updateInc(IncidenciaProf incAl,Long idInc);
    boolean deleteInc(Long idInc);
}
