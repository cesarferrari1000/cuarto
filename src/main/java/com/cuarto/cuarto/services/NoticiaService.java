package com.cuarto.cuarto.services;

import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.modelo.Noticia;
import com.cuarto.cuarto.reposositories.INoticiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticiaService implements INoticiasService{

    private final INoticiaRepository repository;

    public NoticiaService(INoticiaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Noticia> listaNoticia() {
        return repository.findAll();
    }

    @Override
    public Noticia noticeFindById(Long idNotice) {
        return repository.findById(idNotice).orElseThrow(()->
                new RecursoNoEncontradoException("noticia no  encontrada"));
    }

    @Override
    public Noticia insertNotice(Noticia notice) {
        if(notice==null){
            throw new IllegalArgumentException("no se encontro ninguna noticia");

        }
        return repository.save(notice);
    }

    @Override
    @Transactional
    public Noticia updateNotice(Noticia notice, Long idNotice) {
        Noticia upNoticia=noticeFindById(idNotice);
        upNoticia.setEncabezado(notice.getEncabezado());
        upNoticia.setFecha(notice.getFecha());
        upNoticia.setNoticia(notice.getNoticia());
        upNoticia.setUrl(notice.getUrl());
        upNoticia.setTitulo(notice.getTitulo());
        return repository.save(upNoticia);
    }

    @Override
    public void deleteNotice(Long idNotice) {
      Noticia delNotice=noticeFindById(idNotice);
      repository.delete(delNotice);

    }
}
