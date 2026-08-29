package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.IncidenciaAl;
import com.cuarto.cuarto.services.IIncideciaAlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidenciaAl")
public class IncidenciaAlController {
    private final IIncideciaAlService service;

    public IncidenciaAlController(IIncideciaAlService service) {
        this.service = service;
    }

    @GetMapping
    public List<IncidenciaAl> listaInc(){

        return service.listaIncidenciaAl();
    }
    @PostMapping
    public ResponseEntity<?>insertInc(@RequestBody IncidenciaAl incAl){
       IncidenciaAl incidenciaAl=service.insertInc(incAl);
        return ResponseEntity.status(HttpStatus.CREATED).body(incidenciaAl);

    }
}
