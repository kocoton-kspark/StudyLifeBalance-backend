package com.example.demo.dto;

public class SurveyResultResponse {
    private String category;
    private Integer code;
    private String description;
    private Integer major_percentage;
    private Integer study_percentage;
    private Integer outdoor_activity_percentage;

    public SurveyResultResponse() {}

    // Getters and Setters
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getMajor_percentage() { return major_percentage; }
    public void setMajor_percentage(Integer major_percentage) { this.major_percentage = major_percentage; }

    public Integer getStudy_percentage() { return study_percentage; }
    public void setStudy_percentage(Integer study_percentage) { this.study_percentage = study_percentage; }

    public Integer getOutdoor_activity_percentage() { return outdoor_activity_percentage; }
    public void setOutdoor_activity_percentage(Integer outdoor_activity_percentage) { 
        this.outdoor_activity_percentage = outdoor_activity_percentage; 
    }
}
