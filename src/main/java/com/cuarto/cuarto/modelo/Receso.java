package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

@Entity
public class Receso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_receso")
    private Long idReceso;
    private String nivel;
    private String turno;
    private String horario;
    @ManyToOne
    @JoinColumn(name="id_receso_alumno")
    private Asignatura_alumno asignaturaAlumnoReceso;

}
