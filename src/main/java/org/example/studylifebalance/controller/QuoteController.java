package org.example.studylifebalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quotes")
    public ResponseEntity<QuoteResponse> getTodayQuote() {
        try {
            QuoteResponse quote = quoteService.getTodayQuote();
            return ResponseEntity.ok(quote);
        } catch (IllegalArgumentException e) {
            // 잘못된 요청 데이터
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            // 서버 내부 오류
            System.err.println("error: " + e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
