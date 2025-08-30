package org.example.studylifebalance.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PercentageResponse {
    public int totalPercentage;
    public int collegePercentage;

    public PercentageResponse(int totalPercentage, int collegePercentage) {
        this.totalPercentage = totalPercentage;
        this.collegePercentage = collegePercentage;
    }
}
