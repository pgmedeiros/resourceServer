package com.cinefilosanonimos.main.responder.controller;

import com.cinefilosanonimos.main.responder.dto.RespostaDto;
import com.cinefilosanonimos.main.responder.model.Resposta;
import com.cinefilosanonimos.main.responder.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/resposta")
public class RespostaController {

    @Autowired
    private RespostaService service;


    @PostMapping
    public Resposta responder(@RequestBody RespostaDto dto) {
        return service.responder(dto);
    }



}
