package org.example.studylifebalance.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
public class PercentageResponse {
    public int percentage;

    public PercentageResponse(int percentage) {
        this.percentage = percentage + ThreadLocalRandom.current().nextInt(10, 91); ;
    }
}
