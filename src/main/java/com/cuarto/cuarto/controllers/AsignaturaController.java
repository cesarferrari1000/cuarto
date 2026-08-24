package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.Asignatura;
import com.cuarto.cuarto.services.AsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {
    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asignatura>buscarAsignatura(){
        return service.buscarAsignatura();
    }
    @GetMapping("/{codAsig}")
    public ResponseEntity<?>listaAsignaturas(@PathVariable Long codAsig){
        Asignatura asig=service.asignaturaFindById(codAsig);
        return ResponseEntity.ok(asig);

    }
    @PostMapping
    public ResponseEntity<?>insertAsignatura(@RequestBody Asignatura request){
       Asignatura asigInsert=service.insertAsignatura(request);
       return ResponseEntity.status(HttpStatus.CREATED).body(asigInsert);

    }
    @DeleteMapping("/{codAsig}")
    public ResponseEntity<?>deleteAsig(@PathVariable Long codAsig){
       service.asignaturaDelete(codAsig);
        return ResponseEntity.ok("asignatura elminada correctamente");


    }

}
