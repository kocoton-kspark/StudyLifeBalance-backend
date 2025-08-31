package org.example.studylifebalance.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.studylifebalance.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendRequest {

    @NotNull
    private Integer userID;

    @NotNull
    private String college;

    @NotNull
    private Integer grade;

    @NotNull
    private User.Major major;

    @NotNull
    private Integer study_time;

    @NotNull
    private Integer work_time;

    @NotNull
    private Integer rest_time;

    @NotNull
    private Integer sleep_time;

    @NotNull
    private Integer major_credit;

    @NotNull
    private Integer general_grade;

    @NotNull
    private Integer external_activities_time;

    
}
