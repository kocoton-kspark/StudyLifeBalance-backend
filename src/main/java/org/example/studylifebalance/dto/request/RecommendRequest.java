package org.example.studylifebalance.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RecommendRequest {

    @NotNull
    private Integer userID;

    @NotNull
    private Integer study_time;

    @NotNull
    private Integer work_time;

    @NotNull
    private Integer sleep_time;

    @NotNull
    private Integer external_activities_time;
}
