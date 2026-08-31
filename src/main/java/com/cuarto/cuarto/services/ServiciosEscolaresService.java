package com.cuarto.cuarto.services;

import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.modelo.Profesor;
import com.cuarto.cuarto.modelo.Servicios_escolares;
import com.cuarto.cuarto.reposositories.IAlumnoRepository;
import com.cuarto.cuarto.reposositories.IProfesorRepository;
import com.cuarto.cuarto.reposositories.IServiciosEscolaresRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
public class ServiciosEscolaresService implements IServiciosEscolaresService {

    private final IServiciosEscolaresRepository repository;
    private final IProfesorRepository profesorRepository;
    private final IAlumnoRepository alumnoRepository;

    public ServiciosEscolaresService(IServiciosEscolaresRepository repository,
                                     IProfesorRepository profesorRepository,
                                     IAlumnoRepository alumnoRepository) {
        this.repository = repository;
        this.profesorRepository = profesorRepository;
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<Servicios_escolares> listaSE() {
        return repository.findAll();
    }

    @Override
    public Servicios_escolares SeFindById(Long id) {
        return repository.findById(id).orElseThrow(()->new RecursoNoEncontradoException("SE no encontrado"));
    }

    @Override
    public Servicios_escolares insertSE(Servicios_escolares se) {
        if(se==null){
            throw new IllegalArgumentException("SE no encontrado");
        }
         if(validaEmai(se.getEmail())){
             throw new IllegalArgumentException("el email ya esta en la base de datos use otro");
         }

        String matricula=generarMatricula();
        se.setMatricula(matricula);
        return repository.save(se);
    }
    private boolean validaEmai(String email){
        if(repository.existsByEmailIgnoreCase(email)||
            profesorRepository.existsByEmailIgnoreCase(email)||
             alumnoRepository.existsByEmailIgnoreCase(email)){
            return true;
        }else{
            return false;
        }

    }
    private boolean validaEmailParaUpdate(String email, Long idProfesorActual) {
        return repository.existsByEmailIgnoreCaseAndIdServicesNot(email, idProfesorActual)
                || profesorRepository.existsByEmailIgnoreCase(email)
                || alumnoRepository.existsByEmailIgnoreCase(email);
    }
    private String generarMatricula() {
        Optional<Servicios_escolares> ultimo = repository.findTopByOrderByIdServicesDesc();

        int siguienteNumero = 101; // valor inicial

        if (ultimo.isPresent()) {
            String matriculaAnterior = ultimo.get().getMatricula();
            try {
                siguienteNumero = Integer.parseInt(matriculaAnterior) + 1;
            } catch (NumberFormatException | NullPointerException e) {
                // si la matrícula anterior está vacía, null o corrupta, seguimos con 101
                siguienteNumero = 101;
            }
        }

        return String.valueOf(siguienteNumero);
    }
    @Transactional
    @Override
    public Servicios_escolares updateSE(Servicios_escolares se, Long id) {
        Servicios_escolares upSE=SeFindById(id);
        if (se.getEmail() != null && !se.getEmail()
                .equalsIgnoreCase(upSE.getEmail())) {
            if (validaEmailParaUpdate(se.getEmail(), id)) {
                throw new RecursoNoEncontradoException("El email ya se encuentra " +
                        "en la base de datos, utilice otro");
            }
            upSE.setEmail(se.getEmail());
        }

        upSE.setNombre(se.getNombre());
        upSE.setApellidoM(se.getApellidoM());
        upSE.setApellidoP(se.getApellidoP());
        // profEdit.setMatricula(profesor.getMatricula());
        upSE.setPassword(se.getPassword());
        return repository.save(upSE);
    }

    @Override
    @Transactional
    public boolean deleteSE(Long id) {
        Servicios_escolares deleteSE=SeFindById(id);
        repository.delete(deleteSE);
        return true;
    }
}
