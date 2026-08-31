package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Noticia;

import java.util.List;

public interface INoticiasService {

    List<Noticia>listaNoticia();
    Noticia noticeFindById(Long idNotice);
    Noticia insertNotice(Noticia notice);
    Noticia updateNotice(Noticia notice,Long idNotice);
    void deleteNotice(Long idNotice);
}
