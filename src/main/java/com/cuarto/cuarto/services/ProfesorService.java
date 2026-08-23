package com.cuarto.cuarto.services;


import com.cuarto.cuarto.modelo.Profesor;
import com.cuarto.cuarto.modelo.RecursoNoEncontradoException;
import com.cuarto.cuarto.reposositories.IProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService implements IProfesorService{

    private final IProfesorRepository repository;

    public ProfesorService(IProfesorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Profesor> ListaProfesor() {
        return repository.findAll();
    }

    @Override
    public Profesor buscaProfesor(Long  matricula) {
        //Profesor prof=repository.findById(matricula);

        return  repository.findById(matricula)
                .orElseThrow(()->new RecursoNoEncontradoException("Profesor no encontrado con  el id "+matricula));
    }

    @Override
    public Profesor insertaProfesor(Profesor profesor) {
        throw new IllegalArgumentException("El alumno no puede ser nulo");
    }

    @Override
    @Transactional
    public Profesor editProfesor(Long id, Profesor profesor) {
        Profesor profEdit=buscaProfesor(id);
        profEdit.setNombre(profesor.getNombre());
        profEdit.setApellidoM(profesor.getApellidoM());
        profEdit.setApellidoP(profesor.getApellidoP());
        profEdit.setEmail(profesor.getEmail());
        profEdit.setMatricula(profesor.getMatricula());

        return repository.save(profEdit);
    }
}
