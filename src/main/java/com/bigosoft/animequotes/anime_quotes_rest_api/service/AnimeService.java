package com.bigosoft.animequotes.anime_quotes_rest_api.service;

import com.bigosoft.animequotes.anime_quotes_rest_api.dto.AnimeDTO;
import com.bigosoft.animequotes.anime_quotes_rest_api.entity.AnimeEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.repository.AnimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public record AnimeService(AnimeRepository animeRepository
        ,CharacterService characterService
        ,QuoteService quoteService) {


    public List<AnimeDTO> getAllAnime() {
        return animeRepository.findAll()
                .stream().map(animeEntity -> new AnimeDTO(animeEntity.getAnimeName(), animeEntity.getAnimeImage()))
                .toList();
    }

    public List<AnimeDTO> searchAnimeByName(String name) {
        List<AnimeDTO> searchAnime = animeRepository.findByAnimeNameLike(name);
        if (searchAnime.isEmpty()) {
            throw new RuntimeException("Anime Not Found");
        }
        return searchAnime;

    }


    public AnimeDTO getAnimeById(int id) {
        return getOptionalAnimeEntity(id)
                .map(animeEntity -> new AnimeDTO(animeEntity.getAnimeName(), animeEntity.getAnimeImage()))
                .orElseThrow(() -> new RuntimeException("this Id Not Found"));

    }

    public AnimeEntity getAnimeEntity(int id){
        return getOptionalAnimeEntity(id)
                .orElseThrow(() -> new RuntimeException("this Id Not Found"));
    }
    public Optional<AnimeEntity> getOptionalAnimeEntity(int id){
        return animeRepository.findById(id);
    }

    public AnimeDTO addAnime(AnimeDTO anime) {
        if (animeExists(anime.name())) {
            throw new RuntimeException("Anime Already Exists");
        }
        return animeRepository.saveAnime(anime);
    }

    public String updateAnime(AnimeDTO anime, int id) {
        int updateAnimeResult;
        if (ObjectUtils.isEmpty(anime.image())) {
            updateAnimeResult = animeRepository.updateAnimeNameByAnimeIdEquals(anime.name(), id);
        }else {
            updateAnimeResult = animeRepository.updateAnimeNameAndAnimeImageByAnimeId(anime.name(), anime.image(), id);
        }
        if (updateAnimeResult == 1) {
            return "success";
        } else {
            return "not success";
        }
    }


    public boolean animeExists(String name) {
        return animeRepository.countByAnimeNameEquals(name) > 0;
    }

    public String deleteAnime(int id) {
        int deleteAnimeResult = animeRepository.deleteByAnimeIdEquals(id);
        if (deleteAnimeResult == 1) {
            return "success";
        } else {
            return "not success";
        }
    }

}
