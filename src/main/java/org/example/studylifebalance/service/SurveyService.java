package main.java.org.example.studylifebalance.service;

public class SurveyService {
    @Autowired
    private UserRepository userRepository;

    // 전체 category 비율
    public int getCategoryPercentage(int categoryId) {
        int categoryCount = userRepository.countByCategoryId(categoryId);
        int totalCount = userRepository.count();
        if (totalCount == 0) return 0;
        return Math.round((float) categoryCount / totalCount * 100);
    }

    // 학교 내 category 비율
    public int getCategoryPercentageInCollege(int categoryId, String college) {
        int categoryCount = userRepository.countByCategoryIdAndCollege(categoryId, college);
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
}
