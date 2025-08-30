package org.example.studylifebalance.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MentService {
    private final List<String> ments = List.of(
        "혹시 열심히 와 잘을 혼동하고 있지는 않나요?",
        "지금 당신의 스터디와 라이프의 균형을 분석해보세요!",
        "휴식 없이 달리기만 하는 당신, 또는 시작을 망설이는 당신, 당신의 스라벨은 지금 어디에 있나요?",
        "공부로 채운 시간만큼 휴식도 잘 챙기고 있나요? 또는 너무 쉬고만 있지는 않나요? 지금 스라벨 분석을 통해 나만의 밸런스를 찾아보세요!",
        "오늘 하루도 수고한 당신에게, 잠시 멈춰서 물어봅니다. 오늘 당신의 스라벨은 몇 점인가요? 저희 스라벨은 전국에 모든 대학생들의 균형잡힌 삶을 응원합니다!"
    );

    public String getRandomMent() {
        int idx = new Random().nextInt(ments.size());
        return ments.get(idx);
    }
}