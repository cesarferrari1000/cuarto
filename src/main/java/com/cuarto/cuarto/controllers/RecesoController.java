package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.Receso;
import com.cuarto.cuarto.services.IRecesoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receso")
public class RecesoController {
    private final IRecesoService service;

    public RecesoController(IRecesoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Receso> listaReceso(){
        return service.listaReceso();
    }
    @GetMapping("/{idRec}")
    public ResponseEntity<?>recFindById(@PathVariable Long idRec){
        Receso recFindById=service.recesoFindById(idRec);
        return ResponseEntity.ok(recFindById);

    }
    @PostMapping
    public ResponseEntity<?>insertRec(@RequestBody Receso rec){
        Receso insertRec=service.insertReceso(rec);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertRec);

    }
    @PutMapping("/{idRec}")
    public ResponseEntity<?>updateRec(@PathVariable Long idRec,@RequestBody Receso rec){
        Receso upRec=service.updateReceso(rec,idRec);
        return ResponseEntity.ok(upRec);
    }
    @DeleteMapping("/{idRec}")
    public ResponseEntity<?>deleteRec(@PathVariable Long idRec){
        service.deleteReceso(idRec);
        return ResponseEntity.ok("receso eliminado correctamente");

    }

}
