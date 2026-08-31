package com.cuarto.cuarto.services;

import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.modelo.Receso;
import com.cuarto.cuarto.reposositories.IRecesoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecesoService implements IRecesoService {
    private final IRecesoRepository repository;

    public RecesoService(IRecesoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Receso> listaReceso() {
        return repository.findAll();
    }

    @Override
    public Receso recesoFindById(Long idReceso) {

        return repository.findById(idReceso)
                .orElseThrow(()->new RecursoNoEncontradoException("no se encontro receso"));
    }

    @Override
    public Receso insertReceso(Receso receso) {
        if(receso==null){
            throw new IllegalArgumentException("receso invalido");
        }
        return repository.save(receso);
    }

    @Override
    public Receso updateReceso(Receso receso, Long id) {
        Receso updateRec=recesoFindById(id);
        updateRec.setHorario(receso.getHorario());
        updateRec.setNivel(receso.getNivel());
        updateRec.setTurno(receso.getTurno());
        return repository.save(updateRec);
    }

    @Override
    public void deleteReceso(Long id) {
     Receso deleteRec=recesoFindById(id);
     repository.delete(deleteRec);
    }
}
