package com.cuarto.cuarto.modelo;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellidoP;

    private String apellidoM;
    @Column(unique=true)
     private String email;
    @Column(unique=true)
    private String matricula;
    private String nivelEducativo;
    private String turno;
    private String grupo;
    private String tipoUsuario;
    private String password;
    private boolean primerInicio = true;
    @OneToMany(mappedBy = "serviciosEscolaresAl", cascade = CascadeType.ALL)
    private List<IncidenciaAl> incidenciaAl = new ArrayList<>();

    public List<IncidenciaAl> getIncidenciaAl() {
        return incidenciaAl;
    }

    public void setIncidenciaAl(List<IncidenciaAl> incidenciaAl) {
        this.incidenciaAl = incidenciaAl;
    }

    public boolean isPrimerInicio() {
        return primerInicio;
    }

    public void setPrimerInicio(boolean primerInicio) {
        this.primerInicio = primerInicio;
    }

    public void setEmail(String email){
        this.email=email;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail(){
        return email;
    }
    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Alumno(Long id, String nombre, String apellidoP, String matricula,
                  String apellidoM,
                  String nivelEducativo, String turno, String tipoUsuario,
                  String password, String grupo,String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.matricula = matricula;
        this.apellidoM = apellidoM;
        this.nivelEducativo = nivelEducativo;
        this.turno = turno;
        this.tipoUsuario = tipoUsuario;
        this.password = password;
        this.grupo = grupo;
        this.email=email;
    }

    public Alumno(Long id, String nombre, String apellidoP, String apellidoM, String email,
                  String matricula, String nivelEducativo, String turno, String grupo, String tipoUsuario,
                  String password, boolean primerInicio, List<IncidenciaAl> incidenciaAl) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.matricula = matricula;
        this.nivelEducativo = nivelEducativo;
        this.turno = turno;
        this.grupo = grupo;
        this.tipoUsuario = tipoUsuario;
        this.password = password;
        this.primerInicio = primerInicio;
        this.incidenciaAl = incidenciaAl;
    }

    public Alumno(Long id, String nombre, String apellidoP, String apellidoM, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.matricula = matricula;
    }
    public Alumno(){}



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


}
