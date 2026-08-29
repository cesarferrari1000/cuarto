package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.Incidencia;
import com.cuarto.cuarto.services.IIncidenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Incidencia")
public class IncidenciaController {

    private final IIncidenciaService service;

    public IncidenciaController(IIncidenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Incidencia> listaIncidencia(){

        return service.listaIncidenciaAl();
    }

    @PostMapping
    public ResponseEntity<?>insertInc(@RequestBody Incidencia inc){
      Incidencia insert=service.insertInc(inc);
      return ResponseEntity.status(HttpStatus.CREATED).body(insert);

    }


}
