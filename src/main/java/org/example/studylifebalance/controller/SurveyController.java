
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
            int studyRatio = (int) surveyService.getStudyTimeRatio(request.getStudy_time(), request.getRest_time());
            int outSideRatio = request.getExternal_activities_time() != null ? request.getExternal_activities_time() : 0;

            // 카테고리 코드와 이름
            Pair<String, String> categoryPair = surveyService.getCategory(request.getMajor(), majorRatio, studyRatio, outSideRatio);
            String code = categoryPair.getFirst();
            String category = categoryPair.getSecond();
            String description = "description"; // 필요시 실제 설명으로 변경

            // 전체/학교별 백분율 계산 (categoryId가 없으므로 code 사용)
            int totalPercentage = surveyService.getCategoryPercentage(code);
            int collegePercentage = surveyService.getCategoryPercentageInCollege(code, request.getCollege());

            SurveyResponse response = new SurveyResponse(category, code, description, majorRatio, studyRatio, outSideRatio);
            // 만약 SurveyResponse에 totalPercentage, collegePercentage 필드가 있다면 아래처럼 추가
            // response.setTotalPercentage(totalPercentage);
            // response.setCollegePercentage(collegePercentage);

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
