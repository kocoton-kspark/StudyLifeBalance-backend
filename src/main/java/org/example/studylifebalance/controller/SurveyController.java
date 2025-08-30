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
    // 비율 계산 응답 DTO
    public static class RatioResponse {
        public int majorCreditRatio;
        public int generalCreditRatio;
        public int studyTimeRatio;
        public int restTimeRatio;

        public RatioResponse(int majorCreditRatio, int generalCreditRatio, int studyTimeRatio, int restTimeRatio) {
            this.majorCreditRatio = majorCreditRatio;
            this.generalCreditRatio = generalCreditRatio;
            this.studyTimeRatio = studyTimeRatio;
            this.restTimeRatio = restTimeRatio;
        }
    }

    // 비율 계산 요청 DTO
    public static class RatioRequest {
        public int majorCredit;
        public int generalCredit;
        public int studyTime;
        public int restTime;
    }

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
