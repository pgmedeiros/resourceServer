package com.cinefilosanonimos.main.filme.dto;

import com.cinefilosanonimos.main.filme.model.Filme;

public record FilmeResponse(String title) {

    public static FilmeResponse of(Filme filme) {
        return new FilmeResponse(filme.getTitle());
    }

}
