package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Receso;

import java.util.List;

public interface IRecesoService {
    List<Receso> listaReceso();
    Receso recesoFindById(Long idReceso);
    Receso insertReceso(Receso receso);
    Receso updateReceso(Receso receso ,Long id);
    void deleteReceso(Long id);
}
