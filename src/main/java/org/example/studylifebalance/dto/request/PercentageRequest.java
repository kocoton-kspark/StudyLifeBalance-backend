package org.example.studylifebalance.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PercentageRequest {
    @NotNull
    private Integer userID;

    public String category_code;
    public String mbti;
}
