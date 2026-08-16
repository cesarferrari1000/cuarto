package com.cuarto.cuarto.controllers;

import com.cuarto.cuarto.modelo.Alumno;
import com.cuarto.cuarto.reposositories.IAlumnoRepository;
import com.cuarto.cuarto.services.IAlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Alumno")

public class AlumnoController {
private final IAlumnoService repository;

    public AlumnoController(IAlumnoService repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Alumno> traerAlumno(){

        return repository.traerAlumno();
    }
     @GetMapping("/{codAlumno}")
    public ResponseEntity<?>buscarAlumno(@PathVariable Long codAlumn){
             Alumno alumno=repository.idAlumno(codAlumn);
             if(alumno==null){
                 return ResponseEntity.status(HttpStatus.NOT_FOUND)
                         .body("no se encuentra un alumno con este codigo");
             }
        return ResponseEntity.ok(alumno);
     }
     @PostMapping
    public ResponseEntity<?>insertAlumno(@RequestBody Alumno al){

        Alumno alumnocreado=repository.InsertAlumno(al);
         if(alumnocreado==null){
             return ResponseEntity.badRequest().body("no me enviaste ningun alumno");
         }
         return ResponseEntity.status(HttpStatus.CREATED).body(alumnocreado);
    }

@PutMapping("/{codAlumno}")
    public ResponseEntity<?>updateAlumno(@PathVariable Long codAlumn,
                                         @RequestBody Alumno alumno ){
                Alumno alumnoditado=repository.UpdateAlumno(codAlumn,alumno);
                if(alumnoditado==null){
                   return ResponseEntity.badRequest().body("no fue posible editar el alumno");
                }
              return ResponseEntity.ok(alumnoditado);

}
   @DeleteMapping("/{codAlumno}")

    public ResponseEntity<String>DeleteAlumno(@PathVariable Long id){
    Boolean alumnoEliminado=repository.DeleteAlumno(id);
    if(alumnoEliminado==false){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("no se encuentra un alumno con este codigo");
    }
    return ResponseEntity.ok("producto eliminado correctamente");
   }


}
