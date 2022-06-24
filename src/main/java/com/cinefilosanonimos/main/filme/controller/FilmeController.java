package com.cinefilosanonimos.main.filme.controller;

import com.cinefilosanonimos.main.filme.dto.FilmeResponse;
import com.cinefilosanonimos.main.filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("{movieId}")
    public FilmeResponse getMovie(@PathVariable String movieId) {
        return filmeService.buscarFilme(movieId);
    }
}