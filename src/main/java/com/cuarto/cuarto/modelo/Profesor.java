package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_profesor")
    private Long idProfesor;
    private String nombre;
    @Column(name="apellido_p")
    private String apellidoP;
    @Column(name="apellido_m")
    private String apellidoM;
    private String matricula;
    @OneToMany(mappedBy="profesor",cascade=CascadeType.ALL)

    private List<Asignatura> asignaturas=new ArrayList<>();

}
