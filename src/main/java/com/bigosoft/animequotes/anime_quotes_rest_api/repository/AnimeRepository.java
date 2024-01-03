package com.bigosoft.animequotes.anime_quotes_rest_api.repository;

import com.bigosoft.animequotes.anime_quotes_rest_api.dto.AnimeDTO;
import com.bigosoft.animequotes.anime_quotes_rest_api.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AnimeRepository extends JpaRepository<AnimeEntity, Integer> {


    default AnimeDTO saveAnime(AnimeDTO anime) {
        AnimeEntity save = save(new AnimeEntity(anime.name(), anime.image()));
        return Optional.of(save).map(t -> new AnimeDTO(t.getAnimeName(), t.getAnimeImage()))
                .get();
    }


    @Query("select new com.bigosoft.animequotes.anime_quotes_rest_api.dto.AnimeDTO(a.animeName, a.animeImage) from AnimeEntity a where a.animeName like ?1")
    List<AnimeDTO> findByAnimeNameLike(String animeName);

    @Transactional
    @Modifying
    @Query("update AnimeEntity a set a.animeName = ?1  where a.animeId = ?2")
    int updateAnimeNameByAnimeIdEquals(String animeName, int animeId);

    @Transactional
    @Modifying
    @Query("update AnimeEntity a set a.animeName = ?1, a.animeImage = ?2 where a.animeId = ?3")
    int updateAnimeNameAndAnimeImageByAnimeId(String animeName, String animeImage, int animeId);


    @Transactional
    @Modifying
    @Query("delete from AnimeEntity a where a.animeId = ?1")
    int deleteByAnimeIdEquals(int animeId);

    @Query("select count(a) from AnimeEntity a where a.animeName = ?1")
    long countByAnimeNameEquals(String animeName);


}
