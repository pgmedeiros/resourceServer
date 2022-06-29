package com.cinefilosanonimos.main.omdb.service;

import com.cinefilosanonimos.main.omdb.dto.OmdbResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmdbService {

    @Autowired
    private OmdbClient client;

    public OmdbResponse buscarFilmeOmdbApi(String title) {
        return client.getMovie(title);
    }

}
