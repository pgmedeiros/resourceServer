package com.cinefilosanonimos.main.nota.service;

import com.cinefilosanonimos.main.filme.model.Filme;
import com.cinefilosanonimos.main.filme.service.FilmeService;
import com.cinefilosanonimos.main.nota.dto.NotaRequest;
import com.cinefilosanonimos.main.nota.dto.NotaResponse;
import com.cinefilosanonimos.main.nota.enums.ENota;
import com.cinefilosanonimos.main.nota.model.NotaFilme;
import com.cinefilosanonimos.main.nota.repository.NotaRepository;
import com.cinefilosanonimos.main.usuario.model.Usuario;
import com.cinefilosanonimos.main.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.cinefilosanonimos.main.config.security.SecurityService.getUsernameUsuarioLogado;

@Service
public class NotaService {

    @Autowired
    private FilmeService filmeService;
    @Autowired
    private NotaRepository repository;
    @Autowired
    private UsuarioService service;

    public void salvarNota(NotaRequest request) {
        var user = getUsernameUsuarioLogado();
        var usuario = service.buscarUsuario(user);
        var filme = filmeService.buscarFilmePorTitulo(request.titulo());
        repository.save(novaNota(usuario, filme, request.nota()));
    }

    public List<NotaResponse> pegarNotasPorFilme(Integer imdbId) {
        return repository.findByFilme(imdbId)
                .stream()
                .map(NotaResponse::of)
                .collect(Collectors.toList());
    }

    public NotaFilme novaNota(Usuario usuario, Filme filme, ENota nota) {
        return NotaFilme
                .builder()
                .usuario(usuario)
                .filme(filme)
                .nota(nota)
                .build();
    }
}
