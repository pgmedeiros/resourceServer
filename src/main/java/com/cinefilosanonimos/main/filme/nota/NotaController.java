package com.cinefilosanonimos.main.filme.nota;

import com.cinefilosanonimos.main.filme.nota.repository.NotaRepository;
import com.cinefilosanonimos.main.filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies/nota")
public class NotaController {

    @Autowired
    private FilmeService filmeService;
    @Autowired
    private NotaRepository notaRepository;

    @PostMapping("/{idImdb}/notaPositiva")
    public void notaPositiva(@PathVariable String nota){
    }

}
