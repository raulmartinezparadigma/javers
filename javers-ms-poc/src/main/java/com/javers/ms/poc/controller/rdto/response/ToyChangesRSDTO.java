package com.javers.ms.poc.controller.rdto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@GenerateCoverage
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToyChangesRSDTO extends AuditChangeRSDTO {

    List<ToyChangeRSDTO> changes;

}
