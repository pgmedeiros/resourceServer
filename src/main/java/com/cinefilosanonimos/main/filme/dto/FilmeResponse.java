package com.cinefilosanonimos.main.filme.dto;

import com.cinefilosanonimos.main.filme.model.Filme;

public record FilmeResponse(String title, Double nota) {

    public static FilmeResponse of(Filme filme) {
        return new FilmeResponse(filme.getTitle(), filme.getNota());
    }

}
