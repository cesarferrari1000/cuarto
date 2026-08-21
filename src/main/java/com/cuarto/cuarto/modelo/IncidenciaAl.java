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


}
