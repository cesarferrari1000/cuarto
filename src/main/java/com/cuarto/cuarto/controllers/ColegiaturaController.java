package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.Colegiatura;
import com.cuarto.cuarto.services.IColegiaturaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/colegiatura")
public class ColegiaturaController {
    private final IColegiaturaService service;

    public ColegiaturaController(IColegiaturaService service) {
        this.service = service;
    }
     @GetMapping
    public List<Colegiatura>colegiaturaList(){
        return service.listColegiatura();
    }
    @GetMapping("/{codCol}")
    public ResponseEntity<?>buscarColegiatura(@PathVariable Long codCol){
      Optional<Colegiatura> colI=service.colegiaturaFindById(codCol);
        return ResponseEntity.ok(colI);
    }
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorMatriculaYFecha(
            @RequestParam String matricula,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        List<Colegiatura> resultado = service.listByMatriculaAndFecha(matricula, fechaInicio, fechaFin);
        return ResponseEntity.ok(resultado);
    }
    @GetMapping("/buscar-por-fecha")
    public ResponseEntity<?> buscarPorFecha(

            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        List<Colegiatura> resultado = service.ListfindByFechaBetween( fechaInicio, fechaFin);
        return ResponseEntity.ok(resultado);
    }
    @PostMapping
    public ResponseEntity<?>insertColegiatura(@RequestBody Colegiatura col){
        Colegiatura insertCol=service.insertColegiatura(col);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertCol);

    }
    @PutMapping("/{codCol}")
    public ResponseEntity<?>updateColegiatura(@RequestBody Colegiatura col,@PathVariable Long codCol){
        Colegiatura upCol=service.updateColegiatura(col,codCol);
        return ResponseEntity.ok(upCol);

    }
    @DeleteMapping("/{codCol}")
    public ResponseEntity<?>deleteCol(@PathVariable Long codCol){
        service.deleteColegiatura(codCol);
        return ResponseEntity.ok("colegiatura eliminada correctamente");

    }


}
