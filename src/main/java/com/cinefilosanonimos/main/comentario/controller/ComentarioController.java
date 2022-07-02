package com.cinefilosanonimos.main.comentario.controller;

import com.cinefilosanonimos.main.comentario.model.ComentarioFilme;
import com.cinefilosanonimos.main.comentario.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @GetMapping
    public ComentarioFilme pegarComentario(@RequestParam Integer id) {
        return service.pegarComentario(id);
    }

    @PostMapping
    public ComentarioFilme postarComentario(@RequestBody ComentarioFilme comentarioFilme) {
        return service.postarComentario(comentarioFilme);
    }

    @PutMapping
    public ComentarioFilme editarComentario(@RequestBody ComentarioFilme comentarioFilme) {
        return service.editarComentario(comentarioFilme);
    }

    @DeleteMapping
    public void deletarComentario(@RequestParam Integer id) {
        service.deletarComentario(id);
    }

}
