package com.cinefilosanonimos.main.nota.repository;

import com.cinefilosanonimos.main.nota.model.NotaFilme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<NotaFilme, Integer> {
    List<NotaFilme> findByFilme(Integer imdbId);
}
