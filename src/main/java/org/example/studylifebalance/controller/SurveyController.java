package org.example.studylifebalance.controller;

import org.example.studylifebalance.dto.request.RatioRequest;
import org.example.studylifebalance.dto.request.RecommendRequest;
import org.example.studylifebalance.dto.request.SurveyRequest;
import org.example.studylifebalance.dto.response.RatioResponse;
import org.example.studylifebalance.dto.response.RecommendResponse;
import org.example.studylifebalance.dto.response.SurveyResponse;
import org.example.studylifebalance.service.SurveyService;
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

    @PostMapping("/surveys")
    public ResponseEntity<SurveyResponse> getSurveyResult(@RequestBody RatioRequest request) {
        try {
            int majorRatio = (int) surveyService.getMajorCreditRatio(request.majorCredit, request.generalCredit);
            int generalRatio = (int) surveyService.getGeneralCreditRatio(request.majorCredit, request.generalCredit);
            int studyRatio = (int) surveyService.getStudyTimeRatio(request.studyTime, request.restTime);
            int restRatio = (int) surveyService.getRestTimeRatio(request.studyTime, request.restTime);
            SurveyResponse response = new SurveyResponse(majorRatio, generalRatio, studyRatio, restRatio);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 설문조사 결과
//    @PostMapping("/surveys")
//    public ResponseEntity<SurveyResponse> submitSurvey(@RequestBody SurveyRequest request) {
//        try {
//            SurveyResponse result = surveyService.processSurvey(request);
//            return ResponseEntity.ok(result);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    // 전체/학교에서 내 유형 비율
//    @PostMapping("/surveys/percentage")
//    public ResponseEntity<PercentageResponse> getPercentage(@RequestBody PercentageRequest request) {
//        try {
//            PercentageResponse percentage = surveyService.getPercentage(request);
//            return ResponseEntity.ok(percentage);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    // 추천
    @PostMapping("/surveys/recommend")
    public ResponseEntity<RecommendResponse> getRecommendation(@RequestBody RecommendRequest request) {
        try {
            RecommendResponse recommendation = surveyService.getRecommendation(request);
            return ResponseEntity.ok(recommendation);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
