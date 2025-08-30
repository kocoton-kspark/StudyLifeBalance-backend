package org.example.studylifebalance.controller;

import org.example.studylifebalance.dto.request.PercentageRequest;
import org.example.studylifebalance.dto.request.SurveyRequest;
import org.example.studylifebalance.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class PercentageController {

    @Autowired
    SurveyService surveyService;

    @PostMapping("/surveys/percentage")
    public String getPercentMBTI(@RequestBody PercentageRequest request) {
        try {
            int ratio = surveyService.getCategoryPercentageInCollege(request.getCategory_code(), request.getMbti());
            return String.valueOf(ratio);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
