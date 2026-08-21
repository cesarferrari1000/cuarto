package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="incidencia_prof")
public class IncidenciaProf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_incidencia_profesor")
    private Long idIncidenciaProfesor;
    private String incidencia;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="id_prof")
   private Servicios_escolares serviciosEscolaresProf;

    public IncidenciaProf() {
    }


}
