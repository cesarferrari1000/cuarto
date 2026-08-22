package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

@Entity

public class Asignatura {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_asignatura")
private Long idAsignatura;
    private String asignatura;
    @Column(name="nivel_educativo")
    private String nivelEducativo;

    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor profesor;

}
