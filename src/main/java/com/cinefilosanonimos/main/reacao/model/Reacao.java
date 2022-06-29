package com.cinefilosanonimos.main.reacao.model;

import com.cinefilosanonimos.main.comentario.model.ComentarioFilme;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Reacao {
    @Id
    private Integer id;
    @ManyToOne
    private ComentarioFilme comentarioFilme;
}