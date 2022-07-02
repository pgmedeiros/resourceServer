package com.cinefilosanonimos.main.comentario.model;

import com.cinefilosanonimos.main.filme.model.Filme;
import com.cinefilosanonimos.main.responder.model.Resposta;
import com.cinefilosanonimos.main.usuario.model.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMENTARIO_FILME")
@Data
public class ComentarioFilme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String texto;
    @ManyToOne
    @JoinColumn(name = "FK_FILME")
    private Filme filme;
    @ManyToOne
    @JoinColumn(name = "FK_USUARIO")
    private Usuario usuario;
    @OneToMany(mappedBy = "comentarioFilme")
    private List<Resposta> resposta;
}