package com.bigosoft.animequotes.anime_quotes_rest_api.repository;

import com.bigosoft.animequotes.anime_quotes_rest_api.entity.AnimeEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface characterRepository extends JpaRepository<CharacterEntity,Integer> {

    @Query("select c from CharacterEntity c where c.characterName = ?1")
    List<CharacterEntity> findByCharacterNameEquals(String characterName);



}
