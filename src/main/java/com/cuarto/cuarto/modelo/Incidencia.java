package com.cuarto.cuarto.modelo;

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
private Servicios_escolares serviciosEscolares;

}
