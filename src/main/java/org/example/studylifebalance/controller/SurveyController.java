
package org.example.studylifebalance.controller;

import org.example.studylifebalance.dto.request.SurveyRequest;
import org.example.studylifebalance.dto.request.RatioRequest;
import org.example.studylifebalance.dto.request.RecommendRequest;
import org.example.studylifebalance.dto.request.PercentageRequest;
import org.example.studylifebalance.dto.response.RatioResponse;
import org.example.studylifebalance.dto.response.RecommendResponse;
import org.example.studylifebalance.dto.response.SurveyResponse;
import org.example.studylifebalance.dto.response.PercentageResponse;
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


    @PostMapping("/surveys/result")

    public ResponseEntity<SurveyResponse> getSurveyResult(@RequestBody SurveyRequest request) {
        try {
            int majorRatio = (int) surveyService.getMajorCreditRatio(request.getMajor_credit(), request.getGeneral_credit());
            int generalRatio = (int) surveyService.getGeneralCreditRatio(request.getMajor_credit(), request.getGeneral_credit());
            int studyRatio = (int) surveyService.getStudyTimeRatio(request.getStudy_time(), request.getRest_time());
            int restRatio = (int) surveyService.getRestTimeRatio(request.getStudy_time(), request.getRest_time());

            
            int outSideRatio = 0; // 필요시 request에서 받아서 처리
            String category = surveyService.getCategory(request.getMajor(), majorRatio, studyRatio, outSideRatio);

            // 전체/학교별 백분율 계산
            int totalPercentage = surveyService.getCategoryPercentage(request.getCategoryId());
            int collegePercentage = surveyService.getCategoryPercentageInCollege(request.getCategoryId(), request.getCollege());

            SurveyResponse response = new SurveyResponse(category, majorRatio, generalRatio, studyRatio, restRatio, totalPercentage, collegePercentage);

            int outSideRatio = 0;
            Pair<String, String> category = surveyService.getCategory(request.getMajor(), majorRatio, studyRatio, outSideRatio);
            SurveyResponse response = new SurveyResponse(category.getFirst(), category.getSecond(), "description" ,majorRatio, studyRatio, outSideRatio);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }


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
