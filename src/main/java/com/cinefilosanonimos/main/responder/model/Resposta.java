package com.cinefilosanonimos.main.responder.model;

import com.cinefilosanonimos.main.comentario.model.ComentarioFilme;
import com.cinefilosanonimos.main.usuario.model.Usuario;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "FK_COMENTARIO_FILME")
    private ComentarioFilme comentarioFilme;

    @ManyToOne
    @JoinColumn(name = "FK_USUARIO")
    private Usuario usuario;

    private String texto;
}
