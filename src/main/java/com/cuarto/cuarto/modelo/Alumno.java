package com.cuarto.cuarto.modelo;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column(name="apellidoP")
    private String apellidoP;
    @Column(name="apellidoM")
    private String apellidoM;
    @Column(name="matricula")
    private String matricula;

    @OneToMany(mappedBy = "alumnoColegiatura",cascade = CascadeType.ALL)
    private List<Colegiatura> colegiatura=new ArrayList<>();

}
