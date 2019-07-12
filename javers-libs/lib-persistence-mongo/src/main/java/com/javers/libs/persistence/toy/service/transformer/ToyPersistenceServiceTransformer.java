package com.javers.libs.persistence.toy.service.transformer;

import com.javers.libs.persistence.toy.model.ToyMO;
import com.javers.libs.persistence.toy.service.dto.output.ToyPersistenceODTO;

public interface ToyPersistenceServiceTransformer {
	
	ToyPersistenceODTO toToyPersistenceODTO(ToyMO toyMO);
	
}
