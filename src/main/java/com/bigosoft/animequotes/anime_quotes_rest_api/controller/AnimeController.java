package com.bigosoft.animequotes.anime_quotes_rest_api.controller;

import com.bigosoft.animequotes.anime_quotes_rest_api.dto.AnimeDTO;
import com.bigosoft.animequotes.anime_quotes_rest_api.entity.AnimeEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime/")
public record AnimeController(AnimeService animeservice) {


    @GetMapping("all")
    public ResponseEntity<List<AnimeDTO>> getAllAnime() {
        return ResponseEntity.ok(animeservice.getAllAnime());
    }

    @GetMapping("search")
    public ResponseEntity<List<AnimeDTO>> searchAnime(@RequestParam("animeName") String animeName) {
        return ResponseEntity.ok(animeservice.searchAnimeByName(animeName));
    }

    @GetMapping
    public ResponseEntity<AnimeDTO> getAnimeById(@RequestParam("animeId") int animeId) {
        return ResponseEntity.ok(animeservice.getAnimeById(animeId));
    }

    @PostMapping("/add")
    public ResponseEntity<AnimeDTO> addAnime(@RequestBody AnimeDTO anime) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(animeservice.addAnime(anime));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAnime(@RequestBody AnimeDTO updateAnime
            ,@RequestParam("animeId") int animeId) {
        return ResponseEntity.ok(animeservice.updateAnime(updateAnime, animeId));

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAnime(@RequestParam("animeId")  int id) {
        return ResponseEntity.ok(animeservice.deleteAnime(id));
    }
}