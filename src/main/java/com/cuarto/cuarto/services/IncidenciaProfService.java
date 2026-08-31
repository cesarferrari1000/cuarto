package com.cuarto.cuarto.services;

import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.modelo.IncidenciaProf;
import com.cuarto.cuarto.modelo.Profesor;
import com.cuarto.cuarto.reposositories.IIncidenciaProfRepository;
import com.cuarto.cuarto.reposositories.IProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncidenciaProfService implements IIncidenciaProfService{
    private final IIncidenciaProfRepository repository;
    private final IProfesorRepository profRepository;

    public IncidenciaProfService(IIncidenciaProfRepository repository, IProfesorRepository profRepository) {
        this.repository = repository;
        this.profRepository = profRepository;
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
    public IncidenciaProf insertInc(IncidenciaProf incProf) {
        if(incProf==null){
            throw new IllegalArgumentException("no se encontro la incidencia");

        }
        if(incProf.getServiciosEscolaresProf()!=null
                &&incProf.getServiciosEscolaresProf().getIdProfesor()!=null){
            Profesor profesor=profRepository.findById(incProf.getServiciosEscolaresProf().getIdProfesor())
                    .orElseThrow(()->new RecursoNoEncontradoException("id profesor no existente"));
                    incProf.setServiciosEscolaresProf(profesor);
        }

        return repository.save(incProf);
    }

    @Override
    public IncidenciaProf updateInc(IncidenciaProf incAl, Long idInc) {
         IncidenciaProf upProf=incFindById(idInc);
         upProf.setFecha(incAl.getFecha());
         upProf.setIncidencia(incAl.getIncidencia());
        return repository.save(upProf);
    }

    @Override
    public void deleteInc(Long idInc) {
        IncidenciaProf delProf=incFindById(idInc);
        repository.delete(delProf);


    }
}
