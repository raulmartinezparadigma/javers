package com.javers.ms.poc.controller.rdto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Datos de la response para la consulta de un Poc
 */
@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PocRSRDTO {

    @JsonProperty(value = "poc_id")
    private String pocId;

    @JsonProperty(value = "poc_name")
    private String pocName;
}
