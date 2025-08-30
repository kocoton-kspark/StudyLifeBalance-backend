package org.example.studylifebalance.service;

import org.example.studylifebalance.dto.request.RecommendRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecommendService {
    private final String OPENAI_API_KEY = "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"; // 환경변수로 관리 권장
    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    private final RestTemplate restTemplate = new RestTemplate();
    public String getStudyTip(RecommendRequest request) {
        String prompt = "다음 정보를 참고해서 공부를 더 잘하는 법을 100자 내외로 친근하고 재미있게 ~다 말투로 알려줘. 정보: " + request.toString();
        return callGpt(prompt);
    }

    public String getRestTip(RecommendRequest request) {
        String prompt = "다음 정보를 참고해서 휴식을 더 잘하는 법을 100자 내외로 친근하고 재미있게 ~다 말투로 알려줘. 정보: " + request.toString();
        return callGpt(prompt);
    }

    private String callGpt(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(OPENAI_API_KEY);

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-3.5-turbo");
        body.put("messages", new Object[] {
            new HashMap<String, String>() {{
                put("role", "user");
                put("content", prompt);
            }}
        });
        body.put("max_tokens", 200);
        body.put("temperature", 0.7);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_API_URL, entity, Map.class);
            Object choices = response.getBody().get("choices");
            if (choices instanceof java.util.List && !((java.util.List) choices).isEmpty()) {
                Map firstChoice = (Map) ((java.util.List) choices).get(0);
                Map message = (Map) firstChoice.get("message");
                return message.get("content").toString();
            }
        } catch (Exception e) {
            return "GPT API 호출 실패: " + e.getMessage();
        }
        return "GPT 응답 없음";
    }
}
