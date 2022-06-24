package com.cinefilosanonimos.main.filme.service;

import com.cinefilosanonimos.main.comentario.repository.ComentarioRepository;
import com.cinefilosanonimos.main.filme.model.Filme;
import com.cinefilosanonimos.main.filme.repository.FilmeRepository;
import com.cinefilosanonimos.main.omdb.dto.OmdbResponse;
import com.cinefilosanonimos.main.omdb.service.OmdbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FilmeService {

    @Autowired
    private OmdbClient omdbClient;
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public Filme buscarFilme(String title) {
        OmdbResponse retornoOmdb = omdbClient.getMovie(title);
        if(Objects.isNull(retornoOmdb.getImdbID())) {
            return filmeNaoEncontrado();
        }
        if (filmeRepository.findByImdbId(retornoOmdb.getImdbID()).isPresent()) {
            return filmeRepository.findByImdbId(retornoOmdb.getImdbID()).get();
        }
        return salvaFilmeNovaBusca(retornoOmdb);
    }

    public Filme getFilmePropriaBaseDeDados(String id) {
        return filmeRepository.findByImdbId(id).get();
    }

    private Filme salvaFilmeNovaBusca(OmdbResponse omdbResponse) {
        var filme = new Filme();
        filme.setTitle(omdbResponse.getTitle());
        filme.setImdbId(omdbResponse.getImdbID());
        filmeRepository.save(filme);
        return filme;
    }

    private Filme filmeNaoEncontrado() {
        var filme = new Filme();
        filme.setTitle("NAO ENCONTRADO NAO ENCONTRADO");
        return filme;
    }
}
