package com.cuarto.cuarto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_incidencia")
    private Long idIncidencia;
    private String incidencia;
    private Date fecha;

@ManyToOne
        @JoinColumn(name="id_se")
@JsonIgnoreProperties("incidencia")
private Servicios_escolares serviciosEscolares;

    public Incidencia() {
    }

    public Incidencia(Long idIncidencia, String incidencia, Date fecha, Servicios_escolares serviciosEscolares) {
        this.idIncidencia = idIncidencia;
        this.incidencia = incidencia;
        this.fecha = fecha;
        this.serviciosEscolares = serviciosEscolares;
    }

    public Long getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Long idIncidencia) {
        this.idIncidencia = idIncidencia;
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

    public Servicios_escolares getServiciosEscolares() {
        return serviciosEscolares;
    }

    public void setServiciosEscolares(Servicios_escolares serviciosEscolares) {
        this.serviciosEscolares = serviciosEscolares;
    }
}
