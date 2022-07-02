package com.cinefilosanonimos.main.filme.model;

import com.cinefilosanonimos.main.comentario.model.ComentarioFilme;
import com.cinefilosanonimos.main.nota.model.NotaFilme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @NotNull
    private String imdbId;
    @OneToMany(mappedBy = "filme")
    private List<ComentarioFilme> comentarioFilmeList;
    @OneToMany(mappedBy = "nota")
    private List<NotaFilme> nota;

}