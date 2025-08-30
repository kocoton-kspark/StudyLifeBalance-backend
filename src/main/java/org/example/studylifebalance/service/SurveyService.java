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

//    public int getCategoryPercentage(String categoryCode) {
//        int categoryCount = userRepository.countByCategory_CategoryId(categoryCode);
//        long totalCount = userRepository.count();
//        if (totalCount == 0) return 0;
//        return Math.round((float) categoryCount / totalCount * 100);
//    }

    // 학교 내 category 비율
    public int getCategoryPercentageInCollege(String categoryCode, String mbti) {
        int categoryCount = userRepository.countByCategory_CategoryIdAndCollege(categoryCode, mbti);
        int totalCount = userRepository.countByCollege(mbti);
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

    public int getOutsideRatio(boolean outsideTime, String mbti) {
        MBTI mbtiEnum = MBTI.valueOf(mbti.toUpperCase());

        // 점수 가져오기
        double mbtiScore = mbtiEnum.getScore();
        int outsideTimeScore = outsideTime ? 1 : 0;
        double score = (mbtiScore + outsideTimeScore) / 3;
        int roundedScore = (int) Math.round(score * 100);
        if (roundedScore == 0) return 0;
        return roundedScore;
    }


    //카테고리 계산
    public Pair<String, String> getCategory(String major, double majorRatio, double studyTimeRatio, double outsideRatio, int studyTime) {
        String resultCode = "";

        // // 계열
        // switch (major) {
        //     case "인문 사회":
        //         resultCode += "H";
        //         break;
        //     case "자연":
        //         resultCode += "N";
        //         break;
        //     case "공학":
        //         resultCode += "E";
        //         break;
        //     case "예술":
        //         resultCode += "A";
        //         break;
        //     case "체육":
        //         resultCode += "P";
        //         break;
        // }

        // // 전공 / 교양
        // if (majorRatio >= 50) {
        //     resultCode += "M";
        // } else {
        //     resultCode += "G";
        // }

        // // 공부 / 휴식
        // if (studyTimeRatio >= 50) {
        //     resultCode += "S";
        // } else {
        //     resultCode += "R";
        // }

        // // 야외 / 실내
        // if (outsideRatio >= 50) {
        //     resultCode += "O";
        // } else {
        //     resultCode += "I";
        // }

        String resultName = "";

        if (studyTime >= 10){
            resultCode = "NMSI";
            resultName = "침대 역학 아인슈타인";
        }
        else{
            resultCode = "HGRO";
            resultName = "궁궐 탈출 세종대왕";
        }

        // switch (resultCode) {
        //     case "HGRO":
        //         resultName = "궁궐 탈출 세종대왕";
        //         break;
        //     case "NMSI":
        //         resultName = "침대 역학 아인슈타인";
        //         break;
        //     case "EMSI":
        //         resultName = "오늘도 또 유레카 에디슨";
        //         break;
        //     case "AMRO":
        //         resultName = "별 보러 산 간 고흐";
        //         break;
        //     case "PGRO":
        //         resultName = "스피닝 타는 엄복동";
        //         break;
        // }

        return Pair.of(resultCode, resultName);
    }

    public String getDescription(String code) {
        switch (code) {
            case "HGRO":
                return "궁궐아 안녕~ 한글 만들었으니 내 삶을 찾아 떠난다!\n\n한글 창제라는 거대한 프로젝트를 끝낸 세종대왕처럼, 당신은 전공 과제나 시험 같은 **굵직한 할 일은 누구보다 똑 부러지게 해내는 인물**입니다. 지성과 책임감을 모두 갖췄죠.\n\n하지만 '임무 완수!'를 외치는 순간, 딱딱하고 정형화된 궁궐(**전공**)을 벗어나 드넓은 세상(**교양**)으로 탐험을 떠납니다. 당신의 시간표는 필수 전공을 제외하면 온갖 흥미로운 교양 수업들로 가득 차 있을 거예요. 심리학, 마케팅, 미술사, 와인 상식까지! 당신의 **지적 호기심은 한곳에 머무르지 않습니다.**\n\n밤새워 연구하던 세종대왕의 DNA는 시험 기간에만 잠시 깨어날 뿐, 평소에는 **'쉴 땐 확실히 쉬자'**는 마인드로 재충전의 시간을 중요하게 생각합니다.\n\n답답한 도서관이나 실내보다는 **햇살 좋은 잔디밭, 힙한 골목 맛집, 훌쩍 떠나는 여행**에서 더 큰 영감을 얻는 타입이죠.";
                break;
            case "NMSI":
                return "뭐? 침대에서 공부하는 거 아니라고? 과연 장소가 문제일까?\n\n세상에서 가장 편안한 연구실, 침대 위에서 모든 것을 탐구하는 당신은 **침대 역학 아인슈타인** 유형입니다.\n당신에게 침대는 단순한 잠자리가 아닙니다. 지식을 탐구하고, 전공 과제를 해결하며, 가끔은 넷플릭스도 즐기는 **만능 베이스캠프**죠. 당신은 최소한의 움직임으로 최대의 효율을 내는 '침대 위 상대성 이론'을 이미 체화한 사람입니다. 최적의 노트북 각도, 허리를 받쳐주는 쿠션의 배치, 손만 뻗으면 닿는 간식 거리까지, 침대 위 모든 것은 당신의 통제 하에 있습니다.\n밖은 시끄럽고 변수가 많지만, 당신의 '침대 우주'에선 오롯이 **전공 지식의 심연**으로 깊게 빠져들 수 있습니다. 남들이 스터디 카페를 찾아 헤맬 때, 당신은 가장 익숙하고 편안한 곳에서 최고의 지적 유희를 즐깁니다.";
                break;
        }
    }
}
