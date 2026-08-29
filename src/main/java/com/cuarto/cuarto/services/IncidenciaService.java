package com.cuarto.cuarto.services;

import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.modelo.Incidencia;
import com.cuarto.cuarto.reposositories.IIncidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncidenciaService implements IIncidenciaService{
    private final IIncidenciaRepository repository;

    public IncidenciaService(IIncidenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Incidencia> listaIncidenciaAl() {
        return repository.findAll();
    }

    @Override
    public Incidencia incFindById(Long idInc) {


        return repository.findById(idInc).orElseThrow(()->new RecursoNoEncontradoException("incidencia no encontrada "));
    }

    @Override
    public Incidencia insertInc(Incidencia incAl) {
        if(incAl==null){
            throw new IllegalArgumentException("");

        }
        return repository.save(incAl);


    }

    @Override
    public Incidencia updateInc(Incidencia incidencia, Long idInc) {

        Incidencia upInc =incFindById(idInc);
        upInc.setFecha(incidencia.getFecha());
        upInc.setIncidencia(incidencia.getIncidencia());
        return repository.save(upInc);
    }

    @Override
    public boolean deleteInc(Long idInc) {
        Incidencia delInc=incFindById(idInc);
        repository.delete(delInc);
        return true;
    }
}
