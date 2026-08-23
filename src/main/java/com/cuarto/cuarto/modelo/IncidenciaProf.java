package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class IncidenciaProf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idIncidenciaProfesor;
    private String incidencia;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="id_prof")
   private Servicios_escolares serviciosEscolaresProf;

    public IncidenciaProf() {
    }

    public IncidenciaProf(Long idIncidenciaProfesor, String incidencia, Date fecha, Servicios_escolares serviciosEscolaresProf) {
        this.idIncidenciaProfesor = idIncidenciaProfesor;
        this.incidencia = incidencia;
        this.fecha = fecha;
        this.serviciosEscolaresProf = serviciosEscolaresProf;
    }

    public Long getIdIncidenciaProfesor() {
        return idIncidenciaProfesor;
    }

    public void setIdIncidenciaProfesor(Long idIncidenciaProfesor) {
        this.idIncidenciaProfesor = idIncidenciaProfesor;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Servicios_escolares getServiciosEscolaresProf() {
        return serviciosEscolaresProf;
    }

    public void setServiciosEscolaresProf(Servicios_escolares serviciosEscolaresProf) {
        this.serviciosEscolaresProf = serviciosEscolaresProf;
    }
}
