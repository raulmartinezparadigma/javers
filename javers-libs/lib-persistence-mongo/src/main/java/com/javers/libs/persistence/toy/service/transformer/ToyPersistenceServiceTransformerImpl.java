package com.javers.libs.persistence.toy.service.transformer;

import com.javers.libs.persistence.toy.model.ToyMO;
import com.javers.libs.persistence.toy.service.dto.output.ToyPersistenceODTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ToyPersistenceServiceTransformerImpl implements ToyPersistenceServiceTransformer {


	@Override
	public ToyPersistenceODTO toToyPersistenceODTO(ToyMO toyMO) {
		return Optional.ofNullable(toyMO)
				.map(toy-> ToyPersistenceODTO.builder().toy(toy).build())
				.orElseThrow(() -> new NullPointerException("toy null not allowed"));
	}
}
