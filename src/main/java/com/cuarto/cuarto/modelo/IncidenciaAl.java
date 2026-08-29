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
    private Alumno serviciosEscolaresAl;


    public IncidenciaAl(){}

    public IncidenciaAl(Long idAlIncidencia, String incidencia, Date fecha, Alumno serviciosEscolaresAl) {
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

    public Alumno getServiciosEscolaresAl() {
        return serviciosEscolaresAl;
    }

    public void setServiciosEscolaresAl(Alumno serviciosEscolaresAl) {
        this.serviciosEscolaresAl = serviciosEscolaresAl;
    }
}
