package com.cuarto.cuarto.services;


import com.cuarto.cuarto.exepciones.RangoFechaInvalidoException;
import com.cuarto.cuarto.modelo.Alumno;
import com.cuarto.cuarto.modelo.Colegiatura;
import com.cuarto.cuarto.exepciones.RecursoNoEncontradoException;
import com.cuarto.cuarto.reposositories.IAlumnoRepository;
import com.cuarto.cuarto.reposositories.IColegiaturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ColegiaturaService implements IColegiaturaService{


    private final IColegiaturaRepository repository;
    private final IAlumnoRepository alumnoRepository;
    public ColegiaturaService(IColegiaturaRepository repository,IAlumnoRepository alumnoRepository)
    {
        this.repository = repository;
        this.alumnoRepository=alumnoRepository;
    }

    @Override
    public List<Colegiatura> listColegiatura() {
        return repository.findAll();
    }

    @Override
    public Optional<Colegiatura> colegiaturaFindById(Long id ) {
        return repository.findById(id);
    }




    @Override
    public Colegiatura insertColegiatura(Colegiatura col) {
        if(col==null){
            return null;

        }
        if (col.getAlumno() != null && col.getAlumno().getId() != null) {
            Alumno alumnoCompleto = alumnoRepository.findById(col.getAlumno().getId())
                    .orElseThrow(() -> new RecursoNoEncontradoException(
                            "alumno no encontrado con id " + col.getAlumno().getId()));
            col.setAlumno(alumnoCompleto);
        }

        return repository.save(col);
    }

    @Override
    @Transactional
    public Colegiatura updateColegiatura(Colegiatura col, Long idCol) {
        Colegiatura colUpdate=repository.findById(idCol)
                .orElseThrow(()->new RecursoNoEncontradoException("colegiatura no encontarda con id "+idCol));

        colUpdate.setMotivo(col.getMotivo());
        colUpdate.setMonto(col.getMonto());
        colUpdate.setFecha(col.getFecha());

        if (col.getAlumno() != null && col.getAlumno().getId() != null) {
            Alumno alumnoCompleto = alumnoRepository.findById(col.getAlumno().getId())
                    .orElseThrow(() -> new RecursoNoEncontradoException(
                            "alumno no encontrado con id " + col.getAlumno().getId()));
            colUpdate.setAlumno(alumnoCompleto);
        }
        return repository.save(colUpdate);
    }

    @Override
    public Boolean deleteColegiatura(Long idDelete) {
        Colegiatura colDelete=repository.findById(idDelete)
                .orElseThrow(()->new RecursoNoEncontradoException("colegiatura no encontrada con id "+idDelete));

        repository.delete(colDelete);
        return true;
    }

    @Override
    public List<Colegiatura> listByMatriculaAndFecha(String matricula, Date fechaInicio, Date fechaFin) {
        Date finReal;
        if (fechaFin != null) {
            finReal = fechaFin;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            finReal = cal.getTime();
        }

        Date hoy = new Date();

        if (fechaInicio.after(hoy)) {
            throw new RecursoNoEncontradoException(
                    "La fecha de inicio no puede ser mayor a la fecha actual");
        }

        if (fechaInicio.after(finReal)) {
            throw new RangoFechaInvalidoException(
                    "La fecha de inicio no puede ser mayor a la fecha final");
        }
        return repository.findByAlumno_MatriculaAndFechaBetween(matricula, fechaInicio, finReal);
    }

    @Override
    public List<Colegiatura> ListfindByFechaBetween(Date fechaInicio, Date fechaFin) {
        Date finReal;
        if (fechaFin != null) {
            finReal = fechaFin;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            finReal = cal.getTime();
        }

        Date hoy = new Date();

        if (fechaInicio.after(hoy)) {
            throw new RecursoNoEncontradoException(
                    "La fecha de inicio no puede ser mayor a la fecha actual");
        }

        if (fechaInicio.after(finReal)) {
            throw new RangoFechaInvalidoException(
                    "La fecha de inicio no puede ser mayor a la fecha final");
        }
        return repository.findByFechaBetween(fechaInicio,fechaFin);
    }
}
