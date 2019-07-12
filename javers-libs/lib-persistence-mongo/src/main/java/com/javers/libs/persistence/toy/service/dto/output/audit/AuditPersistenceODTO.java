package com.javers.libs.persistence.toy.service.dto.output.audit;

import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javers.core.Changes;

@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditPersistenceODTO {

	private Changes auditChanges;

}
