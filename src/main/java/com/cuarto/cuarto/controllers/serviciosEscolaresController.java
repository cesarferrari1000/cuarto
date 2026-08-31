package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.Servicios_escolares;
import com.cuarto.cuarto.services.IServiciosEscolaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serviciosEscolares")
public class serviciosEscolaresController {

    private final IServiciosEscolaresService service;

    public serviciosEscolaresController(IServiciosEscolaresService service) {
        this.service = service;
    }
    @GetMapping
    public List<Servicios_escolares> listaSE(){
        return service.listaSE();

    }
    @GetMapping("/{idSe}")
    public ResponseEntity<?>incFindById(@PathVariable Long idSe){
        Servicios_escolares se=service.SeFindById(idSe);
        return ResponseEntity.ok(se);

    }
    @PostMapping
    public ResponseEntity<?>insertSe(@RequestBody Servicios_escolares se){
        Servicios_escolares insertSe=service.insertSE(se);

        return ResponseEntity.status(HttpStatus.CREATED).body(insertSe);
    }
    @PutMapping("/{idSe}")
    public ResponseEntity<?>updateSe(@PathVariable Long idSe,@RequestBody Servicios_escolares Serv){
        Servicios_escolares upSer=service.updateSE(Serv,idSe);

        return ResponseEntity.ok(upSer);

    }
    @DeleteMapping("/{idSe}")
    public ResponseEntity<?>delSe(@PathVariable Long idSe){
        service.deleteSE(idSe);
        return ResponseEntity.ok("SE eliminado correctamente");

    }
}
