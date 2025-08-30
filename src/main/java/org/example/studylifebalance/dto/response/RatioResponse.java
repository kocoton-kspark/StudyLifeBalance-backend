package org.example.studylifebalance.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatioResponse {

    @NotNull
    public Integer majorCreditRatio;

    @NotNull
    public Integer generalCreditRatio;

    @NotNull
    public Integer studyTimeRatio;

    @NotNull
    public Integer restTimeRatio;
}