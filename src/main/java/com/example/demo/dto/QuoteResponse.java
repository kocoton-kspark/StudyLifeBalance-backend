package com.example.demo.dto;

public class QuoteResponse {
    private String ment;

    public QuoteResponse() {}

    public QuoteResponse(String ment) {
        this.ment = ment;
    }

    public String getMent() {
        return ment;
    }

    public void setMent(String ment) {
        this.ment = ment;
    }
}
