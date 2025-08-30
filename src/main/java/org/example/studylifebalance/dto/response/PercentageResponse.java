package org.example.studylifebalance.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PercentageResponse {
    public int percentage;

    public PercentageResponse(int percentage) {
        this.percentage = percentage;
    }
}
