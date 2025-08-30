package com.example.demo.model;

public class User {
    private Integer userID;
    private String college;
    private Integer grade;
    private String major;

    public User() {}

    public User(Integer userID, String college, Integer grade, String major) {
        this.userID = userID;
        this.college = college;
        this.grade = grade;
        this.major = major;
    }

    // Getters and Setters
    public Integer getUserID() { return userID; }
    public void setUserID(Integer userID) { this.userID = userID; }

    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }

    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
}
