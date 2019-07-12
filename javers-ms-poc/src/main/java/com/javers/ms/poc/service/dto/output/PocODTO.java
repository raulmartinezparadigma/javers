package com.javers.ms.poc.service.dto.output;

import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Datos de respuesta del servicio para consultar un Poc
 */
@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PocODTO {

    private String pocId;
    private String pocName;
}
