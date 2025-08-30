package org.example.studylifebalance.service;

import lombok.extern.slf4j.Slf4j;
import org.example.studylifebalance.dto.request.RecommendRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RecommendService {
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String GEMINI_API_KEY = "";
    private static final String GEMINI_API_URL =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    public String getStudyTip(RecommendRequest request) {
        String prompt = "다음 정보를 참고해서 공부를 더 잘하는 법을 100자 내외로 ~다 말투로 알려줘. 존댓말로 말해줘. 정보: "
                + request.toString();
        return callGemini(prompt);
    }

    public String getRestTip(RecommendRequest request) {
        String prompt = "다음 정보를 참고해서 휴식을 더 잘하는 법을 100자 내외로 ~다 말투로 알려줘. 존댓말로 말해줘. 정보: "
                + request.toString();
        return callGemini(prompt);
    }

    private String callGemini(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Gemini 요청 바디
        Map<String, Object> part = new HashMap<>();
        part.put("text", prompt);

        Map<String, Object> content = new HashMap<>();
        content.put("parts", new Object[]{ part });

        Map<String, Object> generationConfig = new HashMap<>();
        generationConfig.put("maxOutputTokens", 200);
        generationConfig.put("temperature", 0.7);

        Map<String, Object> body = new HashMap<>();
        body.put("contents", new Object[]{ content });
        body.put("generationConfig", generationConfig);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        try {
            // Gemini는 API 키를 URL 파라미터로도 붙여야 함
            String urlWithKey = GEMINI_API_URL + "?key=" + GEMINI_API_KEY;

            ResponseEntity<Map> response = restTemplate.postForEntity(urlWithKey, entity, Map.class);

            List<Map> candidates = (List<Map>) response.getBody().get("candidates");
            if (candidates != null && !candidates.isEmpty()) {
                Map contentMap = (Map) candidates.get(0).get("content");
                List<Map> parts = (List<Map>) contentMap.get("parts");
                return parts.get(0).get("text").toString();
            }
            return "Gemini 응답 없음";
        } catch (Exception e) {
            return "Gemini API 호출 실패: " + e.getMessage();
        }
    }
}
