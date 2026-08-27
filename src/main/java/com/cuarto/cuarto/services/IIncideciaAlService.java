package com.cuarto.cuarto.services;


import com.cuarto.cuarto.modelo.IncidenciaAl;

import java.util.List;

public interface IIncideciaAlService {

    List<IncidenciaAl> listaIncidenciaAl();
    IncidenciaAl incFindById(Long idInc);
    IncidenciaAl insertInc(IncidenciaAl incAl);
    IncidenciaAl updateInc(IncidenciaAl incidenciaAl,Long idInc);
    boolean deleteInc(Long idInc);

}
