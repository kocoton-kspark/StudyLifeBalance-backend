package com.example.demo.dto;

public class PercentageRequest {
    private Integer userID;
    private String college;
    private String code;

    public PercentageRequest() {}

    // Getters and Setters
    public Integer getUserID() { return userID; }
    public void setUserID(Integer userID) { this.userID = userID; }

    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
