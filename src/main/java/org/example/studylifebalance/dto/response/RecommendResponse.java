package org.example.studylifebalance.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendResponse {

    @NotBlank
    private String study_recommend;

    @NotBlank
    private String rest_recommend;
}
