package com.cuarto.cuarto.services;


import com.cuarto.cuarto.modelo.Alumno;
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
        if(profesor==null){throw new IllegalArgumentException("El alumno no puede ser nulo");}

        String nuevaMatricula = generarMatricula();
        System.out.println("Matricula generada: " + nuevaMatricula); // debug temporal
        profesor.setMatricula(nuevaMatricula);
        return repository.save(profesor);
    }
    private String generarMatricula() {
        Optional<Profesor> ultimo = repository.findTopByOrderByIdProfesorDesc();

        int siguienteNumero = 901; // valor inicial

        if (ultimo.isPresent()) {
            String matriculaAnterior = ultimo.get().getMatricula();
            try {
                siguienteNumero = Integer.parseInt(matriculaAnterior) + 1;
            } catch (NumberFormatException | NullPointerException e) {
                // si la matrícula anterior está vacía, null o corrupta, seguimos con 9001
                siguienteNumero = 9001;
            }
        }

        return String.valueOf(siguienteNumero);
    }
    @Override
    @Transactional
    public Profesor editProfesor(Long id, Profesor profesor) {
        Profesor profEdit=buscaProfesor(id);
        profEdit.setNombre(profesor.getNombre());
        profEdit.setApellidoM(profesor.getApellidoM());
        profEdit.setApellidoP(profesor.getApellidoP());
        profEdit.setEmail(profesor.getEmail());
        //profEdit.setMatricula(profesor.getMatricula());
        profEdit.setPassword(profesor.getPassword());
        return repository.save(profEdit);
    }
}
