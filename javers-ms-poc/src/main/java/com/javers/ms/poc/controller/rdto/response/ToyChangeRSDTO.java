package com.javers.ms.poc.controller.rdto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToyChangeRSDTO extends AuditChangeRSDTO {

    private String modelKey;

    @Builder
    public ToyChangeRSDTO(String statusChangedFrom, String statusChangedTo, OffsetDateTime changeDate, String author, Double commitId, String modelKey) {
        super(statusChangedFrom, statusChangedTo, changeDate, author, commitId);
        this.modelKey = modelKey;
    }
}
