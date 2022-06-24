package com.cinefilosanonimos.main.filme.repository;

import com.cinefilosanonimos.main.filme.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    Filme findByImdbId(String id);
}
