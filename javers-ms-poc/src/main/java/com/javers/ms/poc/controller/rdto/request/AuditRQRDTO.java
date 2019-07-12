package com.javers.ms.poc.controller.rdto.request;

import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;
import com.satelite.spring.libs.extender.params.annotation.RequestParamName;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@GenerateCoverage
public class AuditRQRDTO {

    @NotNull
    @RequestParamName("audited_property")
    private String auditedProperty;

    @RequestParamName(value = "changes_from")
    private Long changesFrom;

    @RequestParamName(value = "changes_to")
    private Long changesTo;

    private Integer limit = 100;
}
