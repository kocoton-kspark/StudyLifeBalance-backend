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
    private Integer majorCreditRatio;

    @NotNull
    private Integer studyTimeRatio;

    @NotNull
    private Integer outSideTimeRatio;
}
