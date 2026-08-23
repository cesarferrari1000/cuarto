package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Alumno;

import java.util.List;

public interface IAlumnoService {

    List<Alumno> traerAlumno();
    Alumno idAlumno(Long id);
    Alumno insertAlumno(Alumno alumno);
    Alumno updateAlumno(Long id_alumno,Alumno al);
    boolean deleteAlumno(Long id_alumno);
}
