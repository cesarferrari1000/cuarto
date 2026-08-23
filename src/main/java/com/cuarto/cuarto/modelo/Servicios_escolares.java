package com.cuarto.cuarto.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Servicios_escolares {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long idServices;
private String nombre;

private String apellidoP;

private String apellidoM;
private String matricula;
private String email;
private String password;
    @OneToMany(mappedBy = "serviciosEscolaresAl", cascade = CascadeType.ALL)
    private List<IncidenciaAl> incidenciaAl = new ArrayList<>();
    @OneToMany(mappedBy = "serviciosEscolaresProf", cascade = CascadeType.ALL)
    private List<IncidenciaProf> incidenciaProf = new ArrayList<>();
@OneToMany(mappedBy = "serviciosEscolares",cascade = CascadeType.ALL)
private List<Incidencia> incidencia=new ArrayList<>();
    public Servicios_escolares() {
    }


}
