package com.bigosoft.animequotes.anime_quotes_rest_api.repository;

import com.bigosoft.animequotes.anime_quotes_rest_api.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Integer> {

    @Query("select q from QuoteEntity q where q.quoteBody like ?1")
    List<QuoteEntity> findByQuoteBodyLike(String quoteBody);





}
