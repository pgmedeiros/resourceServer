package com.cinefilosanonimos.main.nota.model;

import com.cinefilosanonimos.main.filme.model.Filme;
import com.cinefilosanonimos.main.nota.enums.ENota;
import com.cinefilosanonimos.main.usuario.model.Usuario;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Builder
@Data
public class NotaFilme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    private Filme filme;
    private ENota nota;
}