package org.example.studylifebalance.controller;

import org.example.studylifebalance.dto.request.RatioRequest;
import org.example.studylifebalance.dto.request.RecommendRequest;
import org.example.studylifebalance.dto.request.SurveyRequest;
import org.example.studylifebalance.dto.response.RatioResponse;
import org.example.studylifebalance.dto.response.RecommendResponse;
import org.example.studylifebalance.dto.response.SurveyResponse;
import org.example.studylifebalance.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
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
    public ResponseEntity<SurveyResponse> getSurveyResult(@RequestBody SurveyRequest request) {
        try {
            int majorRatio = (int) surveyService.getMajorCreditRatio(request.getMajor_credit(), request.getGeneral_credit());
            int generalRatio = (int) surveyService.getGeneralCreditRatio(request.getMajor_credit(), request.getGeneral_credit());
            int studyRatio = (int) surveyService.getStudyTimeRatio(request.getStudy_time(), request.getRest_time());
            int restRatio = (int) surveyService.getRestTimeRatio(request.getStudy_time(), request.getRest_time());
            int outSideRatio = 0;
            Pair<String, String> category = surveyService.getCategory(request.getMajor(), majorRatio, studyRatio, outSideRatio);
            SurveyResponse response = new SurveyResponse(category.getFirst(), category.getSecond(), "description" ,majorRatio, studyRatio, outSideRatio);
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
