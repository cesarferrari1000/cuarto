package com.cuarto.cuarto.services;

import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.modelo.IncidenciaProf;
import com.cuarto.cuarto.reposositories.IIncidenciaProfRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncidenciaProfService implements IIncidenciaProfService{
    private final IIncidenciaProfRepository repository;

    public IncidenciaProfService(IIncidenciaProfRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IncidenciaProf> listaIncidenciaProf() {
        return repository.findAll();
    }

    @Override
    public IncidenciaProf incFindById(Long idInc) {

        return repository.findById(idInc).orElseThrow(()->new RecursoNoEncontradoException("no se encontro la incidencia profesor "));
    }

    @Override
    public IncidenciaProf insertInc(IncidenciaProf incAl) {
        if(incAl==null){
            throw new IllegalArgumentException("no se encontro la incidencia");

        }

        return repository.save(incAl);
    }

    @Override
    public IncidenciaProf updateInc(IncidenciaProf incAl, Long idInc) {
         IncidenciaProf upProf=incFindById(idInc);
         upProf.setFecha(incAl.getFecha());
         upProf.setIncidencia(incAl.getIncidencia());
        return repository.save(upProf);
    }

    @Override
    public boolean deleteInc(Long idInc) {
        IncidenciaProf delProf=incFindById(idInc);
        repository.delete(delProf);

        return true;
    }
}
