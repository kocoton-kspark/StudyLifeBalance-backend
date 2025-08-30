package org.example.studylifebalance.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PercentageRequest {
    public int categoryId;
    public String college;
}
