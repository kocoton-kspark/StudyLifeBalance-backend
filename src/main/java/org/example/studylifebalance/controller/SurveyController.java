package org.example.studylifebalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    // 설문조사 결과
    @PostMapping("/surveys")
    public ResponseEntity<SurveyResultResponse> submitSurvey(@RequestBody SurveyRequest request) {
        try {
            SurveyResultResponse result = surveyService.processSurvey(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 전체/학교에서 내 유형 비율
    @PostMapping("/surveys/percentage")
    public ResponseEntity<PercentageResponse> getPercentage(@RequestBody PercentageRequest request) {
        try {
            PercentageResponse percentage = surveyService.getPercentage(request);
            return ResponseEntity.ok(percentage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 추천
    @PostMapping("/surveys/recommend")
    public ResponseEntity<RecommendationResponse> getRecommendation(@RequestBody RecommendationRequest request) {
        try {
            RecommendationResponse recommendation = surveyService.getRecommendation(request);
            return ResponseEntity.ok(recommendation);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
