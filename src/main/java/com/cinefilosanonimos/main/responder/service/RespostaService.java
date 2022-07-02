package com.cinefilosanonimos.main.responder.service;

import com.cinefilosanonimos.main.comentario.service.ComentarioService;
import com.cinefilosanonimos.main.responder.dto.RespostaDto;
import com.cinefilosanonimos.main.responder.model.Resposta;
import com.cinefilosanonimos.main.responder.repository.RespostaRepository;
import com.cinefilosanonimos.main.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import static com.cinefilosanonimos.main.config.security.SecurityService.getUsernameUsuarioLogado;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository repository;
    @Autowired
    private ComentarioService comentarioService;

    public Resposta responder(RespostaDto dto) {
        var respostaRetorno =  repository.save(of(dto));
        verificaExistenciaComentario(dto);
        return respostaRetorno;
    }

    private void verificaExistenciaComentario(RespostaDto dto) {
        var id = dto.getComentarioId();
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("COMENTÁRIO NAO ENCONTRADO");
        }
    }

    private Resposta of(RespostaDto dto) {
        var usuario = new Usuario(getUsernameUsuarioLogado());
        var comentarioFilme = comentarioService.pegarComentario(dto.getComentarioId());
        return Resposta
                .builder()
                .usuario(usuario)
                .comentarioFilme(comentarioFilme)
                .build();
    }

}
