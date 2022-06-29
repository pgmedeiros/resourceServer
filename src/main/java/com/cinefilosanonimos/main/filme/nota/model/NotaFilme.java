package com.cinefilosanonimos.main.filme.nota.model;

import com.cinefilosanonimos.main.autenticacao.Usuario;
import com.cinefilosanonimos.main.filme.model.Filme;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Builder
public class NotaFilme {

    @Id
    private Integer id;
    @OneToOne
    private Usuario usuario;
    @ManyToOne
    private Filme filme;
    private Double nota;
}