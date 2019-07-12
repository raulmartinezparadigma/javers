package com.javers.ms.poc.service.dto.input;

import com.javers.libs.persistence.toy.model.ToyMO;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Datos de entrada al servicio para crear un Poc
 */
@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PocCreateIDTO {

    private ToyMO toy;

}
