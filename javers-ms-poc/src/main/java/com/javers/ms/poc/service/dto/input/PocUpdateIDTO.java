package com.javers.ms.poc.service.dto.input;


import com.javers.libs.persistence.toy.model.ToyMO;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PocUpdateIDTO {

    private ToyMO toy;

}
