package com.cinefilosanonimos.main.filme.repository;

import com.cinefilosanonimos.main.filme.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    Optional<Filme> findByImdbId(String id);

}
