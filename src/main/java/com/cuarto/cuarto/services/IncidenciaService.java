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
        return null;
    }

    @Override
    public Incidencia updateInc(Incidencia incidencia, Long idInc) {
        return null;
    }

    @Override
    public boolean deleteInc(Long idInc) {
        return false;
    }
}
