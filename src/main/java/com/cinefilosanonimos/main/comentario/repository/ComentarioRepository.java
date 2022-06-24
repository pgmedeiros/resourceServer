package com.cinefilosanonimos.main.comentario.repository;

import com.cinefilosanonimos.main.comentario.model.ComentarioFilme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<ComentarioFilme, Integer> {

    List<ComentarioFilme> findByImdbId(String id);

}
