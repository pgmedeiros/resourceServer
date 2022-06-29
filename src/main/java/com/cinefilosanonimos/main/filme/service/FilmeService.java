package com.cinefilosanonimos.main.filme.service;

import com.cinefilosanonimos.main.comentario.repository.ComentarioRepository;
import com.cinefilosanonimos.main.filme.model.Filme;
import com.cinefilosanonimos.main.filme.repository.FilmeRepository;
import com.cinefilosanonimos.main.omdb.dto.OmdbResponse;
import com.cinefilosanonimos.main.omdb.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private OmdbService omdbService;
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public Filme buscarFilmePorTitulo(String title) {
        var retornoOmdbApi = omdbService.buscarFilmeOmdbApi(title);
        verificaExistenciaFilmeOmdbApi(retornoOmdbApi);
        var retornoBasePropria = buscarFilmePropriaBaseDeDados(title);
        return retornoBasePropria
                .orElse(salvarRetornoOmdbApiEmBasePropria(retornoOmdbApi));
    }

    public Optional<Filme> buscarFilmePropriaBaseDeDados(String id) {
        return filmeRepository.findByImdbId(id);
    }

    private Filme salvarRetornoOmdbApiEmBasePropria(OmdbResponse omdbResponse) {
        var filme = Filme.builder()
                .title(omdbResponse.getTitle())
                .imdbId(omdbResponse.getImdbID())
                .build();
        filmeRepository.save(filme);
        return filme;
    }

    private void verificaExistenciaFilmeOmdbApi(OmdbResponse retornoOmdbApi) {
        if (Objects.isNull(retornoOmdbApi.getImdbID())) {
            throw new RuntimeException("FILME INEXISTENTE");
        }
    }

    public void adicionarNotaPositiva(String id) {
        var retornoBasePropria = buscarFilmePropriaBaseDeDados(id);
    }
}
