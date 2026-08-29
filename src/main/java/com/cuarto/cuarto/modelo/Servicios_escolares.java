package com.cuarto.cuarto.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Servicios_escolares {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long idServices;
private String nombre;

private String apellidoP;

private String apellidoM;
private String matricula;
private String email;
private String password;


@OneToMany(mappedBy = "serviciosEscolares",cascade = CascadeType.ALL)
private List<Incidencia> incidencia=new ArrayList<>();
    public Servicios_escolares() {
    }

    public Servicios_escolares(Long idServices, String nombre, String apellidoP, String apellidoM,
                               String matricula, String email, String password,
                               List<Incidencia> incidencia) {
        this.idServices = idServices;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.matricula = matricula;
        this.email = email;
        this.password = password;
        this.incidencia = incidencia;
    }

    public Long getIdServices() {
        return idServices;
    }

    public void setIdServices(Long idServices) {
        this.idServices = idServices;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Incidencia> getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(List<Incidencia> incidencia) {
        this.incidencia = incidencia;
    }
}
