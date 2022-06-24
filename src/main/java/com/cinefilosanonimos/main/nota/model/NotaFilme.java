package com.cinefilosanonimos.main.nota.model;

import com.cinefilosanonimos.main.filme.model.Filme;
import com.cinefilosanonimos.main.usuario.model.Usuario;

import javax.persistence.*;

@Entity
public class NotaFilme {

    @Id
    private Integer id;
    @OneToOne
    private Usuario usuario;
    @ManyToOne
    private Filme filme;
}