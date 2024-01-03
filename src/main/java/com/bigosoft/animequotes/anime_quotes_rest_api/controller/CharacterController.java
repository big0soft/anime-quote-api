package com.bigosoft.animequotes.anime_quotes_rest_api.controller;

import com.bigosoft.animequotes.anime_quotes_rest_api.entity.CharacterEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character/")
public record CharacterController(CharacterService characterservice) {


    @GetMapping("all")
    public ResponseEntity<List<CharacterEntity>> getAllCharacter() {

        return ResponseEntity.ok(characterservice.getAllCharacter());

    }

    @GetMapping("search")
    public ResponseEntity<List<CharacterEntity>> searchCharacter(@RequestParam("name") String characterName) {
        return ResponseEntity.ok(characterservice.searchCharacter(characterName));

    }

    @GetMapping
    public ResponseEntity<CharacterEntity> getCharacterById(@RequestParam("id") int characterId) {
        return ResponseEntity.ok(characterservice.getCharacterById(characterId));

    }
}
