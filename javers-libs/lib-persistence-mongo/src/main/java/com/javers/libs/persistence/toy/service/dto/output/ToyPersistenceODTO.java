package com.javers.libs.persistence.toy.service.dto.output;

import com.javers.libs.persistence.toy.model.ToyMO;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@GenerateCoverage
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToyPersistenceODTO {

    private ToyMO toy;
}
