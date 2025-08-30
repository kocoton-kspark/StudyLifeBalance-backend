package org.example.studylifebalance.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatioRequest {

    @NotNull
    public Integer majorCredit;

    @NotNull
    public Integer generalCredit;

    @NotNull
    public Integer studyTime;

    @NotNull
    public Integer restTime;
}