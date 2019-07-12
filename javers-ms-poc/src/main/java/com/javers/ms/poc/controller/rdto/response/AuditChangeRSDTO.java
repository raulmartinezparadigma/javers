package com.javers.ms.poc.controller.rdto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.javers.ms.poc.util.CustomOffsetDateTimeSerializer;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

@Data
@GenerateCoverage
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditChangeRSDTO {

    protected String statusChangedFrom;

    protected String statusChangedTo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
    protected OffsetDateTime changeDate;

    protected String author;

    protected Double commitId;

}