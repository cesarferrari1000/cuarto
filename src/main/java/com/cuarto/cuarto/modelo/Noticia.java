package com.cuarto.cuarto.modelo;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_noticia")
    private Long idNoticia;
    private String noticia;
    private String titulo;
    private String url;
    private String encabezado;
    private Date fecha;

    public Noticia() {
    }

    public Long getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Noticia(Long idNoticia, String noticia, String titulo, String url, String encabezado, Date fecha) {
        this.idNoticia = idNoticia;
        this.noticia = noticia;
        this.titulo = titulo;
        this.url = url;
        this.encabezado = encabezado;
        this.fecha = fecha;
    }
}
