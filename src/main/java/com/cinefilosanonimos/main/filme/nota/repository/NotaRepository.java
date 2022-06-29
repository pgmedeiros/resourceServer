package com.cinefilosanonimos.main.filme.nota.repository;

import com.cinefilosanonimos.main.filme.nota.model.NotaFilme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<NotaFilme, Integer> {
}
