package org.example.studylifebalance.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyRequest {

    @NotNull
    private Integer userID;

    @NotBlank
    private String college;

    @NotNull
    private Integer grade;

    @NotBlank
    private String major;

    @NotNull
    private Integer study_time;

    @NotNull
    private Integer sleep_time;

    @NotNull
    private Integer major_credit;

    @NotNull
    private Integer general_credit;

    private Integer external_activities_time;
}
