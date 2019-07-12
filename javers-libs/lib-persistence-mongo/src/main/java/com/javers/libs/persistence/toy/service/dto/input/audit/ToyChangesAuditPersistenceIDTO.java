package com.javers.libs.persistence.toy.service.dto.input.audit;

import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToyChangesAuditPersistenceIDTO {

	private String modelKey;

	private LocalDateTime changesFrom;

	private LocalDateTime changesTo;

	private String propertyToShow;

}
