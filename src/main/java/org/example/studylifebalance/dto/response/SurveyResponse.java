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
    private Integer code;

    @NotBlank
    private String description;

    @NotNull
    public Integer majorCreditRatio;

    @NotNull
    public Integer generalCreditRatio;

    @NotNull
    public Integer studyTimeRatio;

    @NotNull
    public Integer restTimeRatio;
}
