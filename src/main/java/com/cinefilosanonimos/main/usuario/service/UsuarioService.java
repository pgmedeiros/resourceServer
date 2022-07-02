package com.cinefilosanonimos.main.usuario.service;

import com.cinefilosanonimos.main.usuario.model.Usuario;
import com.cinefilosanonimos.main.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario buscarUsuario(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

}
