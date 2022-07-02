package com.cinefilosanonimos.main.comentario.service;

import com.cinefilosanonimos.main.comentario.model.ComentarioFilme;
import com.cinefilosanonimos.main.comentario.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    public ComentarioFilme postarComentario(ComentarioFilme comentarioFilme) {
       return repository.save(comentarioFilme);
    }

    public ComentarioFilme pegarComentario(Integer id) {
        return repository.findById(id).get();
    }

    public void deletarComentario(Integer id) {
        repository.deleteById(id);
    }

    public ComentarioFilme editarComentario(ComentarioFilme comentarioFilme) {
        return repository.save(comentarioFilme);
    }
}
