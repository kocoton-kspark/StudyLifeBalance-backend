package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0")
@CrossOrigin(origins = "*")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    /**
     * 설문조사 결과 제출
     * POST /api/v0/surveys
     */
    @PostMapping("/surveys")
    public ResponseEntity<SurveyResultResponse> submitSurvey(@RequestBody SurveyRequest request) {
        try {
            SurveyResultResponse result = surveyService.processSurvey(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * GPT 추천 받기
     * POST /api/v0/surveys/recommend
     */
    @PostMapping("/surveys/recommend")
    public ResponseEntity<RecommendationResponse> getRecommendation(@RequestBody RecommendationRequest request) {
        try {
            RecommendationResponse recommendation = surveyService.getRecommendation(request);
            return ResponseEntity.ok(recommendation);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * 전체/학교에서 내 유형 비율
     * POST /api/v0/surveys/percentage
     */
    @PostMapping("/surveys/percentage")
    public ResponseEntity<PercentageResponse> getPercentage(@RequestBody PercentageRequest request) {
        try {
            PercentageResponse percentage = surveyService.getPercentage(request);
            return ResponseEntity.ok(percentage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
