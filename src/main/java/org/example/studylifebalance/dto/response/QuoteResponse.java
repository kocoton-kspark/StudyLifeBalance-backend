package org.example.studylifebalance.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuoteResponse {

    @NotBlank
    private String quote;
}
