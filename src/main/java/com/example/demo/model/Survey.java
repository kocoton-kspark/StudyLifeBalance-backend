package com.example.demo.model;

public class Survey {
    private Long id;
    private Integer userID;
    private Integer study_time;
    private Integer work_time;
    private Integer sleep_time;
    private Integer major_credit;
    private Integer general_credit;
    private Integer external_activities_time;
    private String category;
    private Integer code;

    public Survey() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getUserID() { return userID; }
    public void setUserID(Integer userID) { this.userID = userID; }

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

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
}
