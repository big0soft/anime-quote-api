package com.bigosoft.animequotes.anime_quotes_rest_api.controller;


import com.bigosoft.animequotes.anime_quotes_rest_api.entity.QuoteEntity;
import com.bigosoft.animequotes.anime_quotes_rest_api.service.QuoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quote/")
public record QuoteController(QuoteService quoteService) {


    @GetMapping("all")
    public ResponseEntity<List<QuoteEntity>> getAllQuote() {

        return ResponseEntity.ok(quoteService.getAllQuote());

    }

    @GetMapping("search")
    public ResponseEntity<List<QuoteEntity>> searchQuote(@RequestParam String quote) {
        return ResponseEntity.ok(quoteService.searchQuote(quote));

    }

    @GetMapping
    public ResponseEntity<QuoteEntity> getQuoteById(@RequestParam int quoteId) {
        return ResponseEntity.ok(quoteService.getQuoteById(quoteId));

    }
}
