package com.cinefilosanonimos.main.filme.service;

import com.cinefilosanonimos.main.comentario.repository.ComentarioRepository;
import com.cinefilosanonimos.main.filme.dto.FilmeResponse;
import com.cinefilosanonimos.main.filme.model.Filme;
import com.cinefilosanonimos.main.filme.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    private FilmeClient filmeClient;
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public FilmeResponse buscarFilme(String id) {
        var filme = filmeClient.getMovie(id);
        var comentarios = comentarioRepository.findByImdbId(filme.getImdbID());
        return FilmeResponse.builder().comentarioFilmeList(comentarios)
                .title(filme.getTitle()).build();
    }

    public Filme getFilmePropriaBaseDeDados(String id) {
        return filmeRepository.findByImdbId(id);
    }
}
