package com.cinefilosanonimos.main.reacao.model.estender;

import com.cinefilosanonimos.main.reacao.model.EGostei;
import com.cinefilosanonimos.main.reacao.model.Reacao;

import javax.persistence.Entity;

@Entity
public class ReacaoGostar extends Reacao {

    private EGostei gostei;

}
