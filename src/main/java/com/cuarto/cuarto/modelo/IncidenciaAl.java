package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Incidencia_al")
public class IncidenciaAl {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id_al_incidencia")
    private Long idAlIncidencia;
    private String incidencia;
    private Date fecha;

    @ManyToOne
            @JoinColumn(name="id_alumno")
    private Servicios_escolares serviciosEscolaresAl;


    public IncidenciaAl(){}

    public IncidenciaAl(Long idAlIncidencia, String incidencia, Date fecha, Servicios_escolares serviciosEscolaresAl) {
        this.idAlIncidencia = idAlIncidencia;
        this.incidencia = incidencia;
        this.fecha = fecha;
        this.serviciosEscolaresAl = serviciosEscolaresAl;
    }

    public Long getIdAlIncidencia() {
        return idAlIncidencia;
    }

    public void setIdAlIncidencia(Long idAlIncidencia) {
        this.idAlIncidencia = idAlIncidencia;
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

    public Servicios_escolares getServiciosEscolaresAl() {
        return serviciosEscolaresAl;
    }

    public void setServiciosEscolaresAl(Servicios_escolares serviciosEscolaresAl) {
        this.serviciosEscolaresAl = serviciosEscolaresAl;
    }
}
