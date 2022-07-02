package com.cinefilosanonimos.main.nota.dto;

import com.cinefilosanonimos.main.nota.enums.ENota;
import com.cinefilosanonimos.main.nota.model.NotaFilme;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaResponse {

    private Integer id;
    private String username;
    private ENota nota;

    public static NotaResponse of(NotaFilme notaFilme) {
        return NotaResponse
                .builder()
                .id(notaFilme.getId())
                .nota(notaFilme.getNota())
                .username(notaFilme.getUsuario().getUsername())
                .build();
    }
}
