package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.IncidenciaProf;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncidenciaProfService implements IIncidenciaProfService{
    @Override
    public List<IncidenciaProf> listaIncidenciaProf() {
        return List.of();
    }

    @Override
    public IncidenciaProf incFindById(Long idInc) {
        return null;
    }

    @Override
    public IncidenciaProf insertInc(IncidenciaProf incAl) {
        return null;
    }

    @Override
    public IncidenciaProf updateInc(IncidenciaProf incAl, Long idInc) {
        return null;
    }

    @Override
    public boolean deleteInc(Long idInc) {
        return false;
    }
}
