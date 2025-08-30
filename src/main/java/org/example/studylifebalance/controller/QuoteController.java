package org.example.studylifebalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class MentController {
    @Autowired
    private MentService mentService;

    @GetMapping("/ments")
    public ResponseEntity<String> getRandomMent() {
        try {
            String ment = mentService.getRandomMent();
            return ResponseEntity.ok(ment);
        } catch (Exception e) {
            System.err.println("error: " + e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
