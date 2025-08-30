package com.example.demo.dto;

public class PercentageResponse {
    private String result;
    private Integer percentage;

    public PercentageResponse() {}

    public PercentageResponse(String result, Integer percentage) {
        this.result = result;
        this.percentage = percentage;
    }

    // Getters and Setters
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public Integer getPercentage() { return percentage; }
    public void setPercentage(Integer percentage) { this.percentage = percentage; }
}
