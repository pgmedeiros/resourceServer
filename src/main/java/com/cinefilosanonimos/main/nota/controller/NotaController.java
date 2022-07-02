package com.cinefilosanonimos.main.nota.controller;

import com.cinefilosanonimos.main.nota.dto.NotaRequest;
import com.cinefilosanonimos.main.nota.dto.NotaResponse;
import com.cinefilosanonimos.main.filme.service.FilmeService;
import com.cinefilosanonimos.main.nota.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/nota")
public class NotaController {

    @Autowired
    private FilmeService filmeService;
    @Autowired
    private NotaService service;

    @PostMapping
    public void darNota(@RequestBody NotaRequest notaRequest){
        service.salvarNota(notaRequest);
    }

    @GetMapping("/{imdbId}")
    public List<NotaResponse> verNotas(@PathVariable Integer imdbId) {
        return service.pegarNotasPorFilme(imdbId);
    }

}
