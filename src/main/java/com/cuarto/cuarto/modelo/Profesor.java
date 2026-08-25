package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProfesor;
    private String nombre;

    private String apellidoP;

    private String apellidoM;
    private String email;
    @Column(unique = true, nullable = false)
    private String matricula;

    private String password;
    @OneToMany(mappedBy="profesor",cascade=CascadeType.ALL)

    private List<Asignatura> asignaturas=new ArrayList<>();

    public Profesor() {
    }

    public Profesor(Long idProfesor, String apellidoP, String nombre, String apellidoM, String matricula, List<Asignatura> asignaturas,String email) {
        this.idProfesor = idProfesor;
        this.apellidoP = apellidoP;
        this.nombre = nombre;
        this.apellidoM = apellidoM;
        this.matricula = matricula;
        this.asignaturas = asignaturas;
        this.email=email;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @PrePersist
    public void prePersist() {
        if (this.password == null || this.password.isBlank()) {
            this.password = "profesor"; // o genera uno aleatorio, o el que definas
        }
    }
}
