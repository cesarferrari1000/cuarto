package com.cuarto.cuarto.controllers;


import com.cuarto.cuarto.modelo.Noticia;
import com.cuarto.cuarto.services.INoticiasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticia")
public class NoticiaController {
    private final INoticiasService service;

    public NoticiaController(INoticiasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Noticia> listaNotice(){

        return service.listaNoticia();
    }
    @GetMapping("/{idNotice}")
    public ResponseEntity<?>noticeFindById(@PathVariable Long idNotice){
        Noticia noti=service.noticeFindById(idNotice);
        return ResponseEntity.ok(noti);

    }
    @PostMapping
    public ResponseEntity<?>insertNotice(@RequestBody Noticia notice){
        Noticia insertNotice=service.insertNotice(notice);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertNotice);

    }
    @PutMapping("/{idNotice}")
    public ResponseEntity<?>updateNotice(@PathVariable Long idNotice,@RequestBody Noticia notice){
        Noticia upNoticia=service.updateNotice(notice,idNotice);
        return ResponseEntity.ok(upNoticia);

    }
    @DeleteMapping("/{idNotice}")
    public ResponseEntity<?>deleteNotice(@PathVariable Long idNotice){
        service.deleteNotice(idNotice);
        return ResponseEntity.ok("noticia eliminada correctamente");
    }
}
