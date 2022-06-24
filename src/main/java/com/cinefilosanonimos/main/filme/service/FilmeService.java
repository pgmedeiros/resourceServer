package com.cinefilosanonimos.main.filme.service;

import com.cinefilosanonimos.main.comentario.repository.ComentarioRepository;
import com.cinefilosanonimos.main.filme.dto.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    private FilmeClient filmeClient;
    @Autowired
    private ComentarioRepository comentarioRepository;

    public FilmeResponse buscarFilme(String id) {
        var filme = filmeClient.getMovie(id);
        var comentarios = comentarioRepository.findByImdbId(filme.getImdbID());
        return FilmeResponse.builder().comentarioFilmeList(comentarios)
                .title(filme.getTitle()).build();
    }
}
