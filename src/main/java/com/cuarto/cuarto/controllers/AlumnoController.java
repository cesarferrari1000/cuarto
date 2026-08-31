package com.cuarto.cuarto.controllers;

import com.cuarto.cuarto.modelo.Alumno;

import com.cuarto.cuarto.services.IAlumnoService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Alumno")

public class AlumnoController {

private final IAlumnoService service;

    public AlumnoController(IAlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alumno> traerAlumno(){

        return service.traerAlumno();
    }

     @GetMapping("/{codAlumn}")
    public ResponseEntity<?>buscarAlumno(@PathVariable Long codAlumn){
             Alumno alumno=service.idAlumno(codAlumn);

        return ResponseEntity.ok(alumno);
     }
     @PostMapping
    public ResponseEntity<?>insertAlumno(@RequestBody Alumno al){

        Alumno alumnocreado=service.insertAlumno(al);

         return ResponseEntity.status(HttpStatus.CREATED).body(alumnocreado);
    }

@PutMapping("/{codAlumn}")
    public ResponseEntity<?>updateAlumno(@PathVariable Long codAlumn,
                                         @RequestBody Alumno alumno ){
                Alumno alumnoEditado=service.updateAlumno(codAlumn,alumno);

    return ResponseEntity.ok(alumnoEditado);

}
   @DeleteMapping("/{codAlumn}")

    public ResponseEntity<String>deleteAlumno(@PathVariable Long codAlumn){
    service.deleteAlumno(codAlumn);

    return ResponseEntity.ok("Alumno eliminado correctamente");
   }


}
