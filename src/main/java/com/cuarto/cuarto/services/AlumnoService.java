package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Alumno;
import com.cuarto.cuarto.modelo.RecursoNoEncontradoException;
import com.cuarto.cuarto.reposositories.IAlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService implements IAlumnoService{

    private final IAlumnoRepository repository;

    public AlumnoService(IAlumnoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Alumno> traerAlumno() {


        return repository.findAll();
    }

    @Override
    public Alumno idAlumno(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new RecursoNoEncontradoException("alumno no encontrado con id"+id));
    }

    @Override
    public Alumno insertAlumno(Alumno alumno) {
        if(alumno==null){
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }

        return repository.save(alumno);
    }

    @Override
    @Transactional
    public Alumno updateAlumno(Long id_alumno, Alumno al) {
       Alumno alumn=idAlumno(id_alumno);

       alumn.setNombre(al.getNombre());
       alumn.setApellidoP(al.getApellidoP());
       alumn.setApellidoM(al.getApellidoM());
       alumn.setMatricula(al.getMatricula());
       alumn.setId(al.getId());

        return repository.save(alumn);
    }

    @Override
    @Transactional
    public boolean deleteAlumno(Long id_alumno) {
        Alumno alumnoDelete=idAlumno(id_alumno);

        repository.delete(alumnoDelete);
        return true;
    }
}
