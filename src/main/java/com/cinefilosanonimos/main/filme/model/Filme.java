package com.cinefilosanonimos.main.filme.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Filme {

    @Id
    private Integer id;
    private String title;
    private String imdbId;
    private Double nota;
    private Integer numeroDeNotasDadas;

}