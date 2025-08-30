package org.example.studylifebalance.service;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {
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
        return Math.round((double) generalCredit / totalCredit * 100);
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

    //알파벳 조합
    public String getCategory(String major, double majorRatio, double studyTimeRatio, double outsideRatio) {
        String result = "";

        // 계열
        switch (major) {
            case "인문 사회":
                result += "H";
                break;
            case "자연":
                result += "N";
                break;
            case "공학":
                result += "E";
                break;
            case "예술":
                result += "A";
                break;
            case "체육":
                result += "P";
                break;
        }

        // 전공 / 교양
        if (majorRatio >= 50) {
            result += "M";
        } else {
            result += "G";
        }

        // 공부 / 휴식
        if (studyTimeRatio >= 50) {
            result += "S";
        } else {
            result += "R";
        }

        // 야외 / 실내

        return result;
    }
}
