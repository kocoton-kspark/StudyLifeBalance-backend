package com.example.demo.controller;

import com.example.demo.dto.QuoteResponse;
import com.example.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0")
@CrossOrigin(origins = "*")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    /**
     * 오늘의 멘트 조회
     * GET /api/v0/quotes
     */
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
            System.err.println("오늘의 명언 조회 중 오류 발생: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
