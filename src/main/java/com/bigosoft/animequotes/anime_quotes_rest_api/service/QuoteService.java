package com.bigosoft.animequotes.anime_quotes_rest_api.service;

import com.bigosoft.animequotes.anime_quotes_rest_api.entity.QuoteEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record QuoteService(QuoteRepository quoteRepository) {


    public List<QuoteEntity> getAllQuote() {
        return quoteRepository.findAll();
    }

    public List<QuoteEntity> searchQuote(String name) {
        return quoteRepository.findByQuoteBodyLike(name);

    }

    public QuoteEntity getQuoteById(Integer id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public QuoteEntity addQuote(QuoteEntity quoteEntity) {
        return quoteRepository.save(quoteEntity);
    }

    public List<QuoteEntity> addQuote(List<QuoteEntity> quotes) {
        return quoteRepository.saveAll(quotes);
    }


}