package com.cuarto.cuarto.services;


import com.cuarto.cuarto.modelo.Colegiatura;
import com.cuarto.cuarto.modelo.RecursoNoEncontradoException;
import com.cuarto.cuarto.reposositories.IColegiaturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColegiaturaService implements IColegiaturaService{


    private final IColegiaturaRepository repository;

    public ColegiaturaService(IColegiaturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Colegiatura> listColegiatura() {
        return repository.findAll();
    }

    @Override
    public Optional<Colegiatura> colegiaturaFindById(Long id ) {
        return repository.findById(id);
    }

    @Override
    public Colegiatura insertColegiatura(Colegiatura col) {
        if(col==null){
            return null;

        }
        return repository.save(col);
    }

    @Override
    @Transactional
    public Colegiatura updateColegiatura(Colegiatura col, Long idCol) {
        Colegiatura colUpdate=repository.findById(idCol)
                .orElseThrow(()->new RecursoNoEncontradoException("colegiatura no encontarda con id "+idCol));

        colUpdate.setMotivo(col.getMotivo());
        colUpdate.setMonto(col.getMonto());
        colUpdate.setFecha(col.getFecha());

        return repository.save(colUpdate);
    }

    @Override
    public Boolean deleteColegiatura(Long idDelete) {
        Colegiatura colDelete=repository.findById(idDelete)
                .orElseThrow(()->new RecursoNoEncontradoException("colegiatura no encontrada con id "+idDelete));

        repository.delete(colDelete);
        return true;
    }
}
