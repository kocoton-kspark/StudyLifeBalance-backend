package org.example.studylifebalance.service;

import org.example.studylifebalance.model.Ment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public QuoteResponse getQuote() {

        Ment randomMent = quoteRepository.findRandomMent();

        if (randomMent != null) {
            return new QuoteResponse(randomMent.getContent());
        } else {
            throw new RuntimeException("명언 데이터가 없습니다.");
        }
    }
}
