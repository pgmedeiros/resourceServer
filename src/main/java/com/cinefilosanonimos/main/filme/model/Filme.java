package com.cinefilosanonimos.main.filme.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Filme {

    @Id
    private Integer id;
    private String title;
    private String imdbId;
    private Double nota;
}