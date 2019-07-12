package com.javers.ms.poc.controller.rdto.request;

import com.javers.libs.persistence.toy.model.ToyMO;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Datos de la request para la creación de un Poc
 */
@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PocCreateRQRDTO {

    @Valid
    @NotNull
    private ToyMO toy;

}
