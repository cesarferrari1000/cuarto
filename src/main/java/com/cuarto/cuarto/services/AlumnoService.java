package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Alumno;
import com.cuarto.cuarto.modelo.RecursoNoEncontradoException;
import com.cuarto.cuarto.reposositories.IAlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        String nuevaMatricula = generarMatricula();
        System.out.println("Matricula generada: " + nuevaMatricula); // debug temporal
        alumno.setMatricula(nuevaMatricula);
        return repository.save(alumno);

    }

    private String generarMatricula() {
        Optional<Alumno> ultimo = repository.findTopByOrderByIdDesc();

        int siguienteNumero = 9001; // valor inicial

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
    public Alumno updateAlumno(Long id_alumno, Alumno al) {
       Alumno alumn=idAlumno(id_alumno);

       alumn.setNombre(al.getNombre());
       alumn.setApellidoP(al.getApellidoP());
       alumn.setApellidoM(al.getApellidoM());
      // alumn.setMatricula(al.getMatricula());

       alumn.setGrupo(al.getGrupo());
       alumn.setNivelEducativo(al.getNivelEducativo());
       alumn.setTipoUsuario(al.getTipoUsuario());
       alumn.setTurno(al.getTurno());
       alumn.setPassword(al.getPassword());
       alumn.setEmail(al.getEmail());

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
