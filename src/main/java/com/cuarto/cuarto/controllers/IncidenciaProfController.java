package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.IncidenciaProf;
import com.cuarto.cuarto.services.IIncidenciaProfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidenciaProf")
public class IncidenciaProfController {
    private IIncidenciaProfService service;

    public IncidenciaProfController(IIncidenciaProfService service) {
        this.service = service;
    }

    @GetMapping
    public List<IncidenciaProf>listaIncidenciaProf(){

        return service.listaIncidenciaProf();
    }
    @GetMapping("/{idInc}")
    public ResponseEntity<?>IncProfFindById(@PathVariable Long idInc){
        IncidenciaProf incidenciaProf=service.incFindById(idInc);

        return ResponseEntity.ok(incidenciaProf);

    }
    @PostMapping
    public ResponseEntity<?>insertIncidencia(@RequestBody IncidenciaProf incProf){
        IncidenciaProf insertIProf=service.insertInc(incProf);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertIProf);

    }
    @PutMapping("/{idProf}")
    public ResponseEntity<?>upIncProf(@PathVariable Long idProf,@RequestBody IncidenciaProf incProf){
        IncidenciaProf Iprofesor=service.updateInc(incProf,idProf);
        return ResponseEntity.ok(Iprofesor);

    }
    @DeleteMapping("/{idProf}")
    public ResponseEntity<?>delProf(@PathVariable Long idProf){
        service.deleteInc(idProf);
        return ResponseEntity.ok("incidencia de profesor eliminado correctamente");

    }


}
