package com.cinefilosanonimos.main.usuario.model;

import com.cinefilosanonimos.main.comentario.model.ComentarioFilme;
import com.cinefilosanonimos.main.usuario.enums.ETipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.List;

@Table(name = "USUARIO")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    @OneToMany(mappedBy = "usuario")
    private List<ComentarioFilme> comentario;
    private Integer pontos;
    @Enumerated(EnumType.STRING)
    private ETipo tipo;

    public Usuario(String usernameUsuarioLogado) {
    }
}
