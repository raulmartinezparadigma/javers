package com.javers.libs.persistence.toy.service.dto.input;

import com.javers.libs.persistence.toy.model.ToyMO;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@GenerateCoverage
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToyCreatePersistenceIDTO {

	@NotNull
	private ToyMO toy;
}
