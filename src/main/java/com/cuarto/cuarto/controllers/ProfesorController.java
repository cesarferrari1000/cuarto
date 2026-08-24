package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.Profesor;
import com.cuarto.cuarto.services.IProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Profesor")
public class ProfesorController {
    private final IProfesorService service;

    public ProfesorController(IProfesorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Profesor>listaProfesor(){
        return service.ListaProfesor();
    }
    @GetMapping("/{codProf}")
    public ResponseEntity<?> buscaProfesor(@PathVariable Long codProf){
        Profesor prof=service.buscaProfesor(codProf);
        return ResponseEntity.ok(prof);
    }
    @PostMapping
    public ResponseEntity<?>insertProfesor(@RequestBody Profesor prof){
        Profesor profCreated=service.insertaProfesor(prof);
        return ResponseEntity.status(HttpStatus.CREATED).body(profCreated);
    }
    @PutMapping("/{codProf}")
    public ResponseEntity<?>updateProfesor(@RequestBody Profesor prof ,@PathVariable Long codProf){

        Profesor profEdit= service.editProfesor(codProf,prof);
        return ResponseEntity.ok(profEdit);

    }
}
