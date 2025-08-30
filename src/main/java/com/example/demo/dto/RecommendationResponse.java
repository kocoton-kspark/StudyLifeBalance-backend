package com.example.demo.dto;

public class RecommendationResponse {
    private String recommend;

    public RecommendationResponse() {}

    public RecommendationResponse(String recommend) {
        this.recommend = recommend;
    }

    public String getRecommend() { return recommend; }
    public void setRecommend(String recommend) { this.recommend = recommend; }
}
