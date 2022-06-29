package com.cinefilosanonimos.main.comentario.model;

import com.cinefilosanonimos.main.autenticacao.Usuario;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class ComentarioFilme {

    @Id
    private Integer Id;
    @ManyToOne
    private Usuario usuario;
    private String imdbId;
    private String texto;
}