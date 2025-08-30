package org.example.studylifebalance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

//import javax.persistence.*;

@Entity
@NoArgsConstructor
public class User {
    @Id
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String college;
    private Integer grade;

    public enum Major {
        인문사회계열, 자연계열, 공학계열, 예술계열, 체육계열
    }
    private Major major;
    private Integer studyTime;
    private Integer workTime;
    private Integer restTime;
    private Integer sleepTime;
    private Integer majorCredit;
    private Integer generalCredit;
    private Integer externalActivitiesTime;

    public User(Integer userId, Category category, String college, Integer grade, Major major,
                Integer studyTime, Integer workTime, Integer restTime, Integer sleepTime,
                Integer majorCredit, Integer generalCredit, Integer externalActivitiesTime) {
        this.userId = userId;
        this.category = category;
        this.college = college;
        this.grade = grade;
        this.major = major;
        this.studyTime = studyTime;
        this.workTime = workTime;
        this.restTime = restTime;   
        this.sleepTime = sleepTime;
        this.majorCredit = majorCredit;
        this.generalCredit = generalCredit;
        this.externalActivitiesTime = externalActivitiesTime;
    }

    public Integer getUserId() { return userId; }
    public Category getCategory() { return category; }
    public String getCollege() { return college; }
    public Integer getGrade() { return grade; }
    public Major getMajor() { return major; }
    public Integer getStudyTime() { return studyTime; }
    public Integer getWorkTime() { return workTime; }
    public Integer getRestTime() { return restTime; }
    public Integer getSleepTime() { return sleepTime; }
    public Integer getMajorCredit() { return majorCredit; }
    public Integer getGeneralCredit() { return generalCredit; }
    public Integer getExternalActivitiesTime() { return externalActivitiesTime; }
}
