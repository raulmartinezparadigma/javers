package com.javers.libs.persistence.toy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@GenerateCoverage
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "toy")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToyMO {

    @Id
    private String id;

	private String modelKey;

	private String color;

	private String productionYear;

	private String description;
    
}
