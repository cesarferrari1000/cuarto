package com.cuarto.cuarto.modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity

public class Asignatura {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private Long idAsignatura;
    private String asignatura;

    private String nivelEducativo;

    @ManyToOne
    @JsonIgnoreProperties({"incidenciaProf","asignaturas"})
    @JoinColumn(name="id_profesor")
    private Profesor profesor;

    public Asignatura() {
    }

    public Asignatura(Long idAsignatura, String asignatura, String nivelEducativo, Profesor profesor) {
        this.idAsignatura = idAsignatura;
        this.asignatura = asignatura;
        this.nivelEducativo = nivelEducativo;
        this.profesor = profesor;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
