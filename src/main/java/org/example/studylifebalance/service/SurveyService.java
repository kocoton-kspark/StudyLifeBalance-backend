package org.example.studylifebalance.service;

import org.example.studylifebalance.MBTI;
import org.example.studylifebalance.repository.CategoryRepository;
import org.example.studylifebalance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.util.Pair;

@Service
public class SurveyService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    // 전체 category 비율
    public int getCategoryPercentage(String categoryCode) {
        int categoryCount = userRepository.countByCategory_CategoryId(categoryCode);
        long totalCount = userRepository.count();
        if (totalCount == 0) return 0;
        return Math.round((float) categoryCount / totalCount * 100);
    }

    // 학교 내 category 비율
    public int getCategoryPercentageInCollege(String categoryCode, String college) {
        int categoryCount = userRepository.countByCategory_CategoryIdAndCollege(categoryCode, college);
        int totalCount = userRepository.countByCollege(college);
        if (totalCount == 0) return 0;
        return Math.round((float) categoryCount / totalCount * 100);
    }

    //전공학점 비율 계산
    public double getMajorCreditRatio(int majorCredit, int generalCredit) {
        int totalCredit = majorCredit + generalCredit;
        if (totalCredit == 0) return 0.0;
        return Math.round((double) majorCredit / totalCredit * 100);
    }

    //교양학점 비율 계산
    public double getGeneralCreditRatio(int majorCredit, int generalCredit) {
        int totalCredit = majorCredit + generalCredit;
        if (totalCredit == 0) return 0.0;
        return Math.round((double) generalCredit / totalCredit*100);
    }

    //학습시간 비율 계산
    public double getStudyTimeRatio(int studyTime, int restTime) {

        int totalTime = studyTime + restTime;
        if (totalTime == 0) return 0.0;
        return Math.round((double) studyTime / totalTime * 100);

    }

    //휴식시간 비율 계산
    public double getRestTimeRatio(int studyTime, int restTime) {
        int totalTime = studyTime + restTime;
        if (totalTime == 0) return 0.0;
        return Math.round((double) restTime / totalTime * 100);
    }

    public double getOutsideRatio(boolean outsideTime, String mbti) {
        MBTI mbtiEnum = MBTI.valueOf(mbti.toUpperCase());

        // 점수 가져오기
        double mbtiScore = mbtiEnum.getScore();
        int outsideTimeScore = outsideTime ? 1 : 0;
        double score = (mbtiScore + outsideTimeScore) / 3;
        double roundedScore = Math.round(score * 100.0) / 100.0;
        return roundedScore;
    }

    //카테고리 계산
    public Pair<String, String> getCategory(String major, double majorRatio, double studyTimeRatio, double outsideRatio) {
        String resultCode = "";

        // 계열
        switch (major) {
            case "인문 사회":
                resultCode += "H";
                break;
            case "자연":
                resultCode += "N";
                break;
            case "공학":
                resultCode += "E";
                break;
            case "예술":
                resultCode += "A";
                break;
            case "체육":
                resultCode += "P";
                break;
        }

        // 전공 / 교양
        if (majorRatio >= 50) {
            resultCode += "M";
        } else {
            resultCode += "G";
        }

        // 공부 / 휴식
        if (studyTimeRatio >= 50) {
            resultCode += "S";
        } else {
            resultCode += "R";
        }

        // 야외 / 실내
        if (outsideRatio >= 50) {
            resultCode += "O";
        } else {
            resultCode += "I";
        }

        String resultName = "";

        switch (resultCode) {
            case "HGRO":
                resultName = "궁궐 탈출 세종대왕";
                break;
            case "NMSI":
                resultName = "침대 역학 아인슈타인";
                break;
            case "EMSI":
                resultName = "오늘도 또 유레카 에디슨";
                break;
            case "AMRO":
                resultName = "별 보러 산 간 고흐";
                break;
            case "PGRO":
                resultName = "스피닝 타는 엄복동";
                break;
        }

        return Pair.of(resultCode, resultName);
    }
}
