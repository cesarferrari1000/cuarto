package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Alumno;
import com.cuarto.cuarto.reposositories.IAlumnoRepository;
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
        return repository.findById(id).orElse(null);
    }

    @Override
    public Alumno InsertAlumno(Alumno alumno) {
        if(alumno==null){
            return null;
        }

        return repository.save(alumno);
    }

    @Override
    public Alumno UpdateAlumno(Long id_alumno, Alumno al) {
       Alumno alumn=idAlumno(id_alumno);
       if(alumn==null){
           return null;

       }
       alumn.setNombre(al.getNombre());
       alumn.setApellidoP(al.getApellidoP());
       alumn.setApellidoM(al.getApellidoM());
       alumn.setMatricula(al.getMatricula());
       alumn.setId(al.getId());

        return repository.save(alumn);
    }

    @Override
    public Boolean DeleteAlumno(Long id_alumno) {
        Alumno alumnoDelete=idAlumno(id_alumno);
        if(alumnoDelete==null){
            return null;
        }
        repository.delete(alumnoDelete);
        return true;
    }
}
