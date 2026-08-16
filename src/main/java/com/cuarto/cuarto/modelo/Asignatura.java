package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="Asignatura")
public class Asignatura {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignatura;
    private String asignatura;
    private String nivel_educativo;
    private Integer id_profesor;

    public Asignatura(Long id_asignatura, String asignatura, String nivel_educativo, Integer id_profesor) {
        this.id_asignatura = id_asignatura;
        this.asignatura = asignatura;
        this.nivel_educativo = nivel_educativo;
        this.id_profesor = id_profesor;
    }

    public Long getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getNivel_educativo() {
        return nivel_educativo;
    }

    public void setNivel_educativo(String nivel_educativo) {
        this.nivel_educativo = nivel_educativo;
    }

    public Integer getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Integer id_profesor) {
        this.id_profesor = id_profesor;
    }
}
