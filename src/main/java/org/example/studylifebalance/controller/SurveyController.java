package org.example.studylifebalance.controller;

import org.example.studylifebalance.dto.request.SurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.org.example.studylifebalance.service.SurveyService;

@RestController
@RequestMapping("/api/v0")
public class SurveyController {

    @PostMapping("/surveys/ratios")
    public ResponseEntity<RatioResponse> getRatios(@RequestBody RatioRequest request) {
        try {
            int majorRatio = (int) surveyService.getMajorCreditRatio(request.majorCredit, request.generalCredit);
            int generalRatio = (int) surveyService.getGeneralCreditRatio(request.majorCredit, request.generalCredit);
            int studyRatio = (int) surveyService.getStudyTimeRatio(request.studyTime, request.restTime);
            int restRatio = (int) surveyService.getRestTimeRatio(request.studyTime, request.restTime);
            RatioResponse response = new RatioResponse(majorRatio, generalRatio, studyRatio, restRatio);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Autowired
    private SurveyService surveyService;

    // 설문조사 결과
    @PostMapping("/surveys")
    public ResponseEntity<SurveyResultResponse> submitSurvey(@RequestBody SurveyRequest request) {
        // userID가 없으면 6자리 랜덤값 자동 배정
        if (request.getUserID() == null || request.getUserID() == 0) {
            int randomId = new java.util.Random().nextInt(900000) + 100000; // 100000~999999
            request.setUserID(randomId);
        }
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
            int totalPercentage = surveyService.getCategoryPercentage(request.categoryId);
            int collegePercentage = surveyService.getCategoryPercentageInCollege(request.categoryId, request.college);
            PercentageResponse response = new PercentageResponse(totalPercentage, collegePercentage);
            return ResponseEntity.ok(response);
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
