package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Asignatura;
import com.cuarto.cuarto.modelo.Profesor;
import com.cuarto.cuarto.modelo.RecursoNoEncontradoException;
import com.cuarto.cuarto.reposositories.IAsignaturaRepository;
import com.cuarto.cuarto.reposositories.IProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService implements IAsignaturaService{
    private final IAsignaturaRepository repository;
  //  private final IProfesorRepository profesorRepository;
    public AsignaturaService(IAsignaturaRepository repository,IProfesorRepository profesorRepository){
        this.repository = repository;
      //  this.profesorRepository=profesorRepository;
    }

    @Override

    public List<Asignatura> buscarAsignatura() {
        return repository.findAll();
    }

    @Override
    public Asignatura asignaturaFindById(Long idAsignatura) {
        return repository.findById(idAsignatura)
                .orElseThrow(()->new RecursoNoEncontradoException("Asignatura no encontrada con el id "+idAsignatura));
    }



    @Override
    public Asignatura insertAsignatura(Asignatura asignatura) {
        if(asignatura==null){
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }

        return repository.save(asignatura);
    }

    @Override
    @Transactional
    public Asignatura updateAsignatura(Long id, Asignatura asignatura) {
        Asignatura asignaturaUpdate=asignaturaFindById(id);

        asignaturaUpdate.setAsignatura(asignatura.getAsignatura());
        asignaturaUpdate.setNivelEducativo(asignatura.getNivelEducativo());
        asignaturaUpdate.setProfesor(asignatura.getProfesor());
        return repository.save(asignaturaUpdate);
    }

    @Override
    @Transactional
    public boolean asignaturaDelete(Long id) {
        Asignatura asignaturaDelete=asignaturaFindById(id);


        repository.delete(asignaturaDelete);
        return true;
    }
}
