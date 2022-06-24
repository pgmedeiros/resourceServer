package com.cinefilosanonimos.main.usuario.model;

import com.cinefilosanonimos.main.usuario.tipo.ETipoUsuario;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
public class Usuario {

    @Id
    private Integer Id;
    private String name;
    @Enumerated
    private ETipoUsuario tipo;
}