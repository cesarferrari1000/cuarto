package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.Servicios_escolares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IServiciosEscolaresRepository extends JpaRepository<Servicios_escolares,Long> {
    Optional<Servicios_escolares>findTopByOrderByIdServicesDesc();
    boolean existsByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCaseAndIdServicesNot(String email, Long idServices);
}
