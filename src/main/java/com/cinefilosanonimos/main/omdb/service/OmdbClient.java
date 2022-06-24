package com.cinefilosanonimos.main.omdb.service;

import com.cinefilosanonimos.main.omdb.dto.OmdbResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "omdb", url = "http://www.omdbapi.com/")
public interface OmdbClient {

    @GetMapping("?apikey=34fa53da&t={title}")
    OmdbResponse getMovie(@PathVariable(name = "title") String id);

}
