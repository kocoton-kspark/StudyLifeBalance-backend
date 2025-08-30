package com.example.demo.dto;

public class RecommendationRequest {
    private Integer userID;
    private Integer study_time;
    private Integer work_time;
    private Integer sleep_time;
    private Integer external_activities_time;

    public RecommendationRequest() {}

    // Getters and Setters
    public Integer getUserID() { return userID; }
    public void setUserID(Integer userID) { this.userID = userID; }

    public Integer getStudy_time() { return study_time; }
    public void setStudy_time(Integer study_time) { this.study_time = study_time; }

    public Integer getWork_time() { return work_time; }
    public void setWork_time(Integer work_time) { this.work_time = work_time; }

    public Integer getSleep_time() { return sleep_time; }
    public void setSleep_time(Integer sleep_time) { this.sleep_time = sleep_time; }

    public Integer getExternal_activities_time() { return external_activities_time; }
    public void setExternal_activities_time(Integer external_activities_time) { 
        this.external_activities_time = external_activities_time; 
    }
}
