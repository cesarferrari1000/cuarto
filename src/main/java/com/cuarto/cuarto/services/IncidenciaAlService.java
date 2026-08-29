package com.cuarto.cuarto.services;

import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.modelo.IncidenciaAl;
import com.cuarto.cuarto.reposositories.IIncidenciaAlRepository;
import com.cuarto.cuarto.reposositories.IIncidenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncidenciaAlService implements IIncideciaAlService{

      private final IIncidenciaAlRepository repository;

    public IncidenciaAlService(IIncidenciaAlRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IncidenciaAl> listaIncidenciaAl() {
        return repository.findAll();
    }

    @Override
    public IncidenciaAl incFindById(Long idInc) {

        return repository.findById(idInc).orElseThrow(()->
                new RecursoNoEncontradoException("incidencia de alumno "+idInc+" no encontrada "));
    }

    @Override
    public IncidenciaAl insertInc(IncidenciaAl incAl) {
        if(incAl==null){

            throw new IllegalArgumentException("incidencia invalida ");


        }

        return repository.save(incAl);
    }

    @Override
    @Transactional
    public IncidenciaAl updateInc(IncidenciaAl incidenciaAl,Long idInc) {
         IncidenciaAl upInc=incFindById(idInc);
         upInc.setFecha(incidenciaAl.getFecha());
         upInc.setIncidencia(incidenciaAl.getIncidencia());

        return repository.save(upInc);
    }

    @Override
    @Transactional
    public boolean deleteInc(Long idInc) {
        IncidenciaAl delInc =incFindById(idInc);
        repository.delete(delInc);
       return true;
    }
}
