package com.cinefilosanonimos.main.nota.service;

import com.cinefilosanonimos.main.filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    @Autowired
    private FilmeService filmeService;


    public Double calcularNovaNota(String id, Double notaDoUsuario) {
        var filme = filmeService.getFilmePropriaBaseDeDados(id);
        Double notaAtual = filme.getNota();
        Integer numeroDeVotos = filme.getNumeroDeNotasDadas();
        Double parteDeCima = ((notaAtual * numeroDeVotos) + notaDoUsuario);
        Integer parteDeBaixo =  (numeroDeVotos + 1);
        Double novaNota = parteDeCima / parteDeBaixo;
        filme.setNota(novaNota);
        return novaNota;
    }
}
