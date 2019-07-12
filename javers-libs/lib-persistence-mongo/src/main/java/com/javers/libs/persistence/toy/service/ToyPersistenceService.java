package com.javers.libs.persistence.toy.service;

import com.javers.libs.persistence.toy.service.dto.input.ToyCreatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.input.ToyUpdatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.output.ToyPersistenceODTO;

public interface ToyPersistenceService {


	void createToy(ToyCreatePersistenceIDTO toyCreatePersistenceIDTO);

	ToyPersistenceODTO updateToy(String modelKey, ToyUpdatePersistenceIDTO toyUpdatePersistenceIDTO);


}
