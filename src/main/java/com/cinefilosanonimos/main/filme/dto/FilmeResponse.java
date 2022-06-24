package com.cinefilosanonimos.main.filme.dto;

import com.cinefilosanonimos.main.comentario.model.ComentarioFilme;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class FilmeResponse implements Serializable {

    public String title;
    public List<ComentarioFilme> comentarioFilmeList;
    public Double nota;

}
