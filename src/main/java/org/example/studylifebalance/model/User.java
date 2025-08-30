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
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
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
    private Boolean outsideTime;
    private String mbti;

    public User(Integer userId, Category category, String college, Integer grade, Major major,
                Integer studyTime, Integer workTime, Integer restTime, Integer sleepTime,
                Integer majorCredit, Integer generalCredit, Integer externalActivitiesTime, Boolean outsideTime, String mbti) {
        this.userId = userId;
        this.category = category;
        this.college = college;
        this.grade = grade;
        this.major = major;
        this.studyTime = studyTime;
        this.restTime = restTime;   
        this.sleepTime = sleepTime;
        this.majorCredit = majorCredit;
        this.generalCredit = generalCredit;
        this.externalActivitiesTime = externalActivitiesTime;
        this.outsideTime = outsideTime;
        this.mbti = mbti;
    }

    public Integer getUserId() { return userId; }
    public Category getCategory() { return category; }
    public String getCollege() { return college; }
    public Integer getGrade() { return grade; }
    public Major getMajor() { return major; }
    public Integer getStudyTime() { return studyTime; }

    public Integer getRestTime() { return restTime; }
    public Integer getSleepTime() { return sleepTime; }
    public Integer getMajorCredit() { return majorCredit; }
    public Integer getGeneralCredit() { return generalCredit; }
    public Integer getExternalActivitiesTime() { return externalActivitiesTime; }
    public Boolean getOutsideTime() { return outsideTime; }
    public String getMbti() { return mbti; }

    // 더미 데이터 생성 메서드
    public static User getDummyUser1(Category category) {
        // 국민대학교, 자연계열, 3학년, 15학점(전공), 3학점(교양), 대외활동 X, 실내+2, 공부+2, 수면 12, ENFP, 공부 3+0, 휴식 7
        return new User(
            1,
            category, // category 객체 필요
            "국민대학교",
            1,
            Major.자연계열,
            5, // studyTime: 3시간 + 대외활동 0시간
            3, // workTime
            6, // restTime
            9, // sleepTime
            5, // majorCredit
            5, // generalCredit
            0, // externalActivitiesTime
            true, // outsideTime
            "ISFP" // mbti
        );
    }

    public static User getDummyUser2(Category category) {
        // 숙명여자대학교, 인문사회계열, 2학년, 3학점(전공), 15학점(교양), 대외활동 O(4시간), 야외+2, 휴식+2, 수면 7, ISTJ, 공부 7+4, 휴식 3
        return new User(
            2,
            category, // category 객체 필요
            "숙명여자대학교",
            2,
            Major.인문사회계열,
            7 + 4, // studyTime: 7시간 + 대외활동 4시간
            7 + 4, // workTime -> studyTime으로 변경
            3, // restTime
            7, // sleepTime
            3, // majorCredit
            15, // generalCredit
            4, // externalActivitiesTime
            true, // outsideTime
            "ISFP" // mbti
        );
    }
}
