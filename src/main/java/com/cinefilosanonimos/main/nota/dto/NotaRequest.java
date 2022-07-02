package com.cinefilosanonimos.main.nota.dto;

import com.cinefilosanonimos.main.nota.enums.ENota;

public record NotaRequest(ENota nota, String titulo) {
}
