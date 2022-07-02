package com.cinefilosanonimos.main.responder.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Data
public class RespostaDto {

    @NotBlank
    private Integer comentarioId;
    @NotBlank
    private Integer texto;
}
