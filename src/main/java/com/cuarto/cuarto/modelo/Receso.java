package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

@Entity
public class Receso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idReceso;
    private String nivel;
    private String turno;
    private String horario;
    @ManyToOne
    @JoinColumn(name="id_receso_alumno")
    private AsignaturaAlumno asignaturaAlumnoReceso;

    public Receso() {
    }

    public Receso(Long idReceso, String nivel, String turno, String horario, AsignaturaAlumno asignaturaAlumnoReceso) {
        this.idReceso = idReceso;
        this.nivel = nivel;
        this.turno = turno;
        this.horario = horario;
        this.asignaturaAlumnoReceso = asignaturaAlumnoReceso;
    }

    public Long getIdReceso() {
        return idReceso;
    }

    public void setIdReceso(Long idReceso) {
        this.idReceso = idReceso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public AsignaturaAlumno getAsignaturaAlumnoReceso() {
        return asignaturaAlumnoReceso;
    }

    public void setAsignaturaAlumnoReceso(AsignaturaAlumno asignaturaAlumnoReceso) {
        this.asignaturaAlumnoReceso = asignaturaAlumnoReceso;
    }


}
