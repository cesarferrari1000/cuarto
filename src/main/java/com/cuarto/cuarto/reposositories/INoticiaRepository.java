package com.cuarto.cuarto.reposositories;

import com.cuarto.cuarto.modelo.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface INoticiaRepository extends JpaRepository<Noticia,Long> {

}
