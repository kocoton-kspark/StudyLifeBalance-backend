package com.example.demo.dto;

public class SurveyRequest {
    private Integer userID;
    private String college;
    private Integer grade;
    private String major;
    private Integer study_time;
    private Integer work_time;
    private Integer sleep_time;
    private Integer major_credit;
    private Integer general_credit;
    private Integer external_activities_time;

    // 기본 생성자
    public SurveyRequest() {}

    // Getters and Setters
    public Integer getUserID() { return userID; }
    public void setUserID(Integer userID) { this.userID = userID; }

    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }

    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public Integer getStudy_time() { return study_time; }
    public void setStudy_time(Integer study_time) { this.study_time = study_time; }

    public Integer getWork_time() { return work_time; }
    public void setWork_time(Integer work_time) { this.work_time = work_time; }

    public Integer getSleep_time() { return sleep_time; }
    public void setSleep_time(Integer sleep_time) { this.sleep_time = sleep_time; }

    public Integer getMajor_credit() { return major_credit; }
    public void setMajor_credit(Integer major_credit) { this.major_credit = major_credit; }

    public Integer getGeneral_credit() { return general_credit; }
    public void setGeneral_credit(Integer general_credit) { this.general_credit = general_credit; }

    public Integer getExternal_activities_time() { return external_activities_time; }
    public void setExternal_activities_time(Integer external_activities_time) { 
        this.external_activities_time = external_activities_time; 
    }
}
