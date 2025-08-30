package com.example.demo.service;

import com.example.demo.dto.*;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SurveyService {

    /**
     * 설문조사 결과 처리
     */
    public SurveyResultResponse processSurvey(SurveyRequest request) {
        // 설문조사 데이터를 기반으로 유형 분석
        String category = analyzeCategory(request);
        Integer code = generateCode(request);
        String description = generateDescription(category);
        
        // 백분율 계산 (예시 로직)
        Integer majorPercentage = calculateMajorPercentage(request);
        Integer studyPercentage = calculateStudyPercentage(request);
        Integer outdoorPercentage = calculateOutdoorPercentage(request);

        SurveyResultResponse response = new SurveyResultResponse();
        response.setCategory(category);
        response.setCode(code);
        response.setDescription(description);
        response.setMajor_percentage(majorPercentage);
        response.setStudy_percentage(studyPercentage);
        response.setOutdoor_activity_percentage(outdoorPercentage);

        return response;
    }

    /**
     * GPT 추천 생성
     */
    public RecommendationResponse getRecommendation(RecommendationRequest request) {
        String recommendation = generateRecommendation(request);
        return new RecommendationResponse(recommendation);
    }

    /**
     * 유형별 비율 조회
     */
    public PercentageResponse getPercentage(PercentageRequest request) {
        // 데이터베이스에서 유형별 비율 조회 (예시 로직)
        String result = "균형형";
        Integer percentage = calculatePercentageByCollege(request);
        
        return new PercentageResponse(result, percentage);
    }

    // 내부 메서드들 (분석 로직)
    private String analyzeCategory(SurveyRequest request) {
        int totalTime = request.getStudy_time() + request.getWork_time() + 
                       request.getSleep_time() + request.getExternal_activities_time();
        
        if (request.getStudy_time() > totalTime * 0.4) {
            return "학습 집중형";
        } else if (request.getWork_time() > totalTime * 0.3) {
            return "실무 중심형";
        } else if (request.getExternal_activities_time() > totalTime * 0.2) {
            return "활동 적극형";
        } else {
            return "균형형";
        }
    }

    private Integer generateCode(SurveyRequest request) {
        // 유형에 따른 코드 생성 로직
        return new Random().nextInt(1000) + 1;
    }

    private String generateDescription(String category) {
        switch (category) {
            case "학습 집중형":
                return "학업에 많은 시간을 투자하며 체계적으로 학습하는 유형입니다.";
            case "실무 중심형":
                return "실무 경험을 중시하며 현장 중심적 사고를 하는 유형입니다.";
            case "활동 적극형":
                return "다양한 외부 활동에 적극적으로 참여하는 유형입니다.";
            default:
                return "학습, 실무, 활동 간의 균형을 추구하는 유형입니다.";
        }
    }

    private Integer calculateMajorPercentage(SurveyRequest request) {
        // 전공 관련 시간 비율 계산
        int totalCredit = request.getMajor_credit() + request.getGeneral_credit();
        return totalCredit > 0 ? (request.getMajor_credit() * 100) / totalCredit : 50;
    }

    private Integer calculateStudyPercentage(SurveyRequest request) {
        // 학습 시간 비율 계산
        int totalTime = request.getStudy_time() + request.getWork_time() + 
                       request.getExternal_activities_time();
        return totalTime > 0 ? (request.getStudy_time() * 100) / totalTime : 30;
    }

    private Integer calculateOutdoorPercentage(SurveyRequest request) {
        // 외부 활동 시간 비율 계산
        int totalTime = request.getStudy_time() + request.getWork_time() + 
                       request.getExternal_activities_time();
        return totalTime > 0 ? (request.getExternal_activities_time() * 100) / totalTime : 20;
    }

    private String generateRecommendation(RecommendationRequest request) {
        // GPT 스타일 추천 생성 (실제로는 OpenAI API 연동)
        StringBuilder recommendation = new StringBuilder();
        
        recommendation.append("당신의 시간 배분을 분석한 결과: ");
        
        if (request.getStudy_time() >= 6) {
            recommendation.append("학습에 충분한 시간을 투자하고 있습니다. ");
        } else {
            recommendation.append("학습 시간을 늘려보는 것을 권장합니다. ");
        }
        
        if (request.getSleep_time() < 6) {
            recommendation.append("충분한 수면을 취하는 것이 중요합니다. ");
        }
        
        if (request.getExternal_activities_time() < 2) {
            recommendation.append("외부 활동을 통해 경험을 넓혀보세요.");
        }
        
        return recommendation.toString();
    }

    private Integer calculatePercentageByCollege(PercentageRequest request) {
        // 실제로는 데이터베이스에서 해당 대학/유형의 비율을 조회
        Random random = new Random();
        return random.nextInt(30) + 15; // 15-45% 범위
    }
}
