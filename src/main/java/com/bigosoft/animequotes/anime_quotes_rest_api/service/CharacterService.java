package com.bigosoft.animequotes.anime_quotes_rest_api.service;

import com.bigosoft.animequotes.anime_quotes_rest_api.entity.CharacterEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.repository.characterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public record CharacterService(characterRepository characterRepository,QuoteService quoteService) {

    public List<CharacterEntity> getAllCharacter() {
        return characterRepository.findAll();
    }

    public List<CharacterEntity> searchCharacter(String name) {
        return characterRepository.findByCharacterNameEquals(name);

    }

    public CharacterEntity getCharacterById(int id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }


}