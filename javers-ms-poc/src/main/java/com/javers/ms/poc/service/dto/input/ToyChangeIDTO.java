package com.javers.ms.poc.service.dto.input;

import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@GenerateCoverage
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToyChangeIDTO {

    private String modelKey;

    private LocalDateTime changesFrom;

    private LocalDateTime changesTo;

    private String propertyToShow;
}
