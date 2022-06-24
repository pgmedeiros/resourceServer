package com.cinefilosanonimos.main.filme.service;

import com.cinefilosanonimos.main.filme.dto.OmdbResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "omdb", url = "http://www.omdbapi.com/")
public interface FilmeClient {

    @GetMapping("?apikey=34fa53da&i={id}")
    OmdbResponse getMovie(@PathVariable(name = "id") String id);

}
