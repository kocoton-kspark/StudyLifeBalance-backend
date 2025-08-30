<<<<<<< HEAD
package main.java.org.example.studylifebalance.service;

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
=======
package org.example.studylifebalance.service;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

>>>>>>> 909cb5a200acd080553280d4726525005f637a39
}
