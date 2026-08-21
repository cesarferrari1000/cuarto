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
    private Alumno alumnoColegiatura;
}
