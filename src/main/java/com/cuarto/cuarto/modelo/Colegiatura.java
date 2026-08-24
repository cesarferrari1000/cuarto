package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Colegiatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_colegiatura")
    private Long idColegiatura;
    private String motivo;
    private double monto;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    public Colegiatura() {
    }

    public Colegiatura(String motivo, double monto, Long idColegiatura, Date fecha, Alumno alumno) {
        this.motivo = motivo;
        this.monto = monto;
        this.idColegiatura = idColegiatura;
        this.fecha = fecha;
        this.alumno = alumno;
    }

    public Long getIdColegiatura() {
        return idColegiatura;
    }

    public void setIdColegiatura(Long idColegiatura) {
        this.idColegiatura = idColegiatura;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumnoColegiatura) {
        this.alumno = alumno;
    }
}
