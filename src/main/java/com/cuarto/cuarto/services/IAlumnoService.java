package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Alumno;

import java.util.List;

public interface IAlumnoService {

    List<Alumno> traerAlumno();
    Alumno idAlumno(Long id);
    Alumno InsertAlumno(Alumno alumno);
    Alumno UpdateAlumno(Long id_alumno,Alumno al);
    Boolean DeleteAlumno(Long id_alumno);
}
