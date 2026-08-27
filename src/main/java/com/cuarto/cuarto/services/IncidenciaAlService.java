package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.IncidenciaAl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncidenciaAlService implements IIncideciaAlService{
    @Override
    public List<IncidenciaAl> listaIncidenciaAl() {
        return List.of();
    }

    @Override
    public IncidenciaAl incFindById(Long idInc) {
        return null;
    }

    @Override
    public IncidenciaAl insertInc(IncidenciaAl incAl) {
        return null;
    }

    @Override
    public IncidenciaAl updateInc(IncidenciaAl incidenciaAl, Long idInc) {
        return null;
    }

    @Override
    public boolean deleteInc(Long idInc) {
        return false;
    }
}
