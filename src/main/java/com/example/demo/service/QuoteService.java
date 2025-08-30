package com.example.demo.service;

import com.example.demo.dto.QuoteResponse;
import com.example.demo.model.Ment;
import com.example.demo.repository.MentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    @Autowired
    private MentRepository mentRepository;

    public QuoteResponse getTodayQuote() {
        // 데이터베이스에서 랜덤 명언 조회
        Ment randomMent = mentRepository.findRandomMent();
        
        if (randomMent != null && randomMent.getContent() != null) {
            return new QuoteResponse(randomMent.getContent());
        } else {
            throw new RuntimeException("데이터베이스에 명언 데이터가 없습니다.");
        }
    }
}
