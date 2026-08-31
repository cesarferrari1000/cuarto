package com.cuarto.cuarto.services;


import com.cuarto.cuarto.modelo.Profesor;
import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.reposositories.IAlumnoRepository;
import com.cuarto.cuarto.reposositories.IProfesorRepository;
import com.cuarto.cuarto.reposositories.IServiciosEscolaresRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService implements IProfesorService{

    private final IProfesorRepository repository;
     private final IServiciosEscolaresRepository SeRepository;
     private final IAlumnoRepository AlRepository;

    public ProfesorService(IProfesorRepository repository, IServiciosEscolaresRepository seRepository,
                           IAlumnoRepository alRepository) {
        this.repository = repository;
            this.SeRepository = seRepository;
        this.AlRepository = alRepository;
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
        if(validaEmail(profesor.getEmail())){throw new RecursoNoEncontradoException("el email ya se encuentra en la base de datos utilize otro ");}

        String nuevaMatricula = generarMatricula();
        System.out.println("Matricula generada: " + nuevaMatricula); // debug temporal
        profesor.setMatricula(nuevaMatricula);
        return repository.save(profesor);
    }
    private boolean validaEmailParaUpdate(String email, Long idProfesorActual) {
        return repository.existsByEmailIgnoreCaseAndIdProfesorNot(email, idProfesorActual)
                || SeRepository.existsByEmailIgnoreCase(email)
                || AlRepository.existsByEmailIgnoreCase(email);
    }
    private boolean validaEmail(String email){
        if(repository.existsByEmailIgnoreCase(email)||
        SeRepository.existsByEmailIgnoreCase(email)||
        AlRepository.existsByEmailIgnoreCase(email)){
            return true;
        }else{return false;}
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
                siguienteNumero = 901;
            }
        }

        return String.valueOf(siguienteNumero);
    }
    @Override
    @Transactional
    public Profesor editProfesor(Long id, Profesor profesor) {
        Profesor profEdit=buscaProfesor(id);
        if (profesor.getEmail() != null && !profesor.getEmail()
                .equalsIgnoreCase(profEdit.getEmail())) {
            if (validaEmailParaUpdate(profesor.getEmail(), id)) {
                throw new RecursoNoEncontradoException("El email ya se encuentra " +
                        "en la base de datos, utilice otro");
            }
            profEdit.setEmail(profesor.getEmail());
        }

        profEdit.setNombre(profesor.getNombre());
        profEdit.setApellidoM(profesor.getApellidoM());
        profEdit.setApellidoP(profesor.getApellidoP());
       // profEdit.setMatricula(profesor.getMatricula());
        profEdit.setPassword(profesor.getPassword());

        return repository.save(profEdit);
    }

    @Override
    @Transactional
    public void deleteProfesor(Long id) {
        Profesor delProfesor=buscaProfesor(id);
        repository.delete(delProfesor);
    }

}
