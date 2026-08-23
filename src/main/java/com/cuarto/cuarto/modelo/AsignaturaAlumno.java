package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AsignaturaAlumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscr;
    private String status;
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;
    @ManyToOne
    @JoinColumn(name="idAlumno")
    Alumno alumno;
    @ManyToOne
    @JoinColumn(name="idAsignatura")
    Asignatura asignatura;
    @OneToMany(mappedBy = "asignaturaAlumnoReceso",cascade = CascadeType.ALL)
    List<Receso> receso=new ArrayList<>();

    public AsignaturaAlumno() {
    }

    public AsignaturaAlumno(Long idInscr, String status, String lunes, String martes, String miercoles, String jueves, String viernes, Alumno alumno, Asignatura asignatura, List<Receso> receso) {
        this.idInscr = idInscr;
        this.status = status;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.receso = receso;
    }

    public Long getIdInscr() {
        return idInscr;
    }

    public void setIdInscr(Long idInscr) {
        this.idInscr = idInscr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<Receso> getReceso() {
        return receso;
    }

    public void setReceso(List<Receso> receso) {
        this.receso = receso;
    }
}
