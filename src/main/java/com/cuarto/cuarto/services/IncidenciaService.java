package com.cuarto.cuarto.services;

import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.modelo.Incidencia;
import com.cuarto.cuarto.modelo.Servicios_escolares;
import com.cuarto.cuarto.reposositories.IIncidenciaRepository;
import com.cuarto.cuarto.reposositories.IServiciosEscolaresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncidenciaService implements IIncidenciaService{
    private final IIncidenciaRepository repository;

       private final IServiciosEscolaresRepository SERepository;
    public IncidenciaService(IIncidenciaRepository repository,IServiciosEscolaresRepository SERepository) {
        this.SERepository=SERepository;
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
            throw new IllegalArgumentException("incidencia de tipo alumno no encontrada ");
        }
        if(incAl.getServiciosEscolares()!=null&&incAl.getServiciosEscolares().getIdServices()!=null){
            Servicios_escolares SeCompleto=SERepository.findById(incAl.getServiciosEscolares().getIdServices())
                    .orElseThrow(()->new RecursoNoEncontradoException("id de Servicios Escolares no existente"));
            incAl.setServiciosEscolares(SeCompleto);
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
    public void deleteInc(Long idInc) {
        Incidencia delInc=incFindById(idInc);
        repository.delete(delInc);
    }
}
