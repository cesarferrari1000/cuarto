package com.cuarto.cuarto.services;

import com.cuarto.cuarto.modelo.Servicios_escolares;

import java.util.List;

public interface IServiciosEscolaresService {


    List<Servicios_escolares>listaSE();
    Servicios_escolares SeFindById(Long id);
    Servicios_escolares insertSE(Servicios_escolares se);
    Servicios_escolares updateSE(Servicios_escolares se,Long id);


    boolean deleteSE(Long id);
}
