package org.example.studylifebalance.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyResponse {

    @NotBlank
    private String category;

    @NotNull
    private String code;

    @NotBlank
    private String description;

    @NotNull
    private Integer major_ratio;

    @NotNull
    private Integer study_ratio;

//    @NotNull
//    private Integer rest_ratio;

    @NotNull
    private Integer outdoor_activity_ratio;

    private Integer sleepShortage;

    private Integer totalPercentage;

    private Integer collegePercentage;

}
