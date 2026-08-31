package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.Incidencia;
import com.cuarto.cuarto.modelo.Servicios_escolares;
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
    @GetMapping("/{idInc}")
    public ResponseEntity<?>incAlFindById(@PathVariable Long idInc){
        Incidencia incSe=service.incFindById(idInc);
        return ResponseEntity.ok(incSe);
    }

    @PostMapping
    public ResponseEntity<?>insertInc(@RequestBody Incidencia inc){
      Incidencia insert=service.insertInc(inc);
      return ResponseEntity.status(HttpStatus.CREATED).body(insert);

    }
    @PutMapping("/{idInc}")
    public ResponseEntity<?>updateInc(@PathVariable Long idInc,@RequestBody Incidencia incidencia){
        Incidencia upInc=service.updateInc(incidencia,idInc);
        return ResponseEntity.ok(upInc);
    }
    @DeleteMapping("/{idInc}")
    public ResponseEntity<?>delInc(@PathVariable Long idInc){
        service.deleteInc(idInc);
        return ResponseEntity.ok("incidencia eliminada correctamente");
    }


}
