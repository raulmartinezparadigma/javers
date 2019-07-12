package com.javers.ms.poc.service.dto.output;

import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javers.core.Changes;

@Data
@GenerateCoverage
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToyChangeODTO {

    private Changes toyChanges;
}