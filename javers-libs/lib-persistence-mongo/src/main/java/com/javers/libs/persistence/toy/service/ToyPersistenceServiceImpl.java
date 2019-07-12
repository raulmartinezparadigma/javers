package com.javers.libs.persistence.toy.service;

import com.google.common.collect.ImmutableMap;
import com.javers.libs.persistence.toy.model.ToyMO;
import com.javers.libs.persistence.toy.repository.ToyRepository;
import com.javers.libs.persistence.toy.service.dto.input.ToyCreatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.input.ToyUpdatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.output.ToyPersistenceODTO;
import com.javers.libs.persistence.toy.service.transformer.ToyPersistenceServiceTransformer;
import com.satelite.spring.libs.validation.exception.CustomValidatorCodeErrorException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.util.Strings;
import org.javers.core.Javers;
import org.javers.spring.auditable.AuthorProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ToyPersistenceServiceImpl implements ToyPersistenceService {

	private static final Logger LOG = LoggerFactory.getLogger(ToyPersistenceServiceImpl.class);
	public static final String MODEL_KEY_COMMIT_KEY = "modelKey";

	@Autowired
	private ToyRepository repository;

	@Autowired
	private ToyPersistenceServiceTransformer transformer;

	@Autowired
	private Javers javers;

	@Autowired
	private AuthorProvider authorProvider;


	@Override
	public void createToy(ToyCreatePersistenceIDTO toyCreatePersistenceIDTO) {
		Validate.notNull(toyCreatePersistenceIDTO, "toyPersistenceIDTO null not allowed");

		LOG.debug("Query para crear el toy con id {}", toyCreatePersistenceIDTO.getToy().getModelKey());

		try {

			ToyMO result = repository.insert(toyCreatePersistenceIDTO.getToy());

			createAndCommitAuditChange(result);

		} catch (DuplicateKeyException dke) {
			LOG.error("Error al insertar: Modelo duplicado", dke);
			throw new CustomValidatorCodeErrorException("Error");
		}
	}

	@Override
	public ToyPersistenceODTO updateToy(String modelKey, ToyUpdatePersistenceIDTO toyUpdatePersistenceIDTO) { //@on

		Validate.notBlank(modelKey, "modelKey blank not allowed");
		Validate.notNull(toyUpdatePersistenceIDTO, "toyUpdatePersistenceIDTO null not allowed");

		if (!StringUtils.equals(modelKey, toyUpdatePersistenceIDTO.getToy().getModelKey())) {
			throw new CustomValidatorCodeErrorException();
		}

		ToyMO originalToy = repository.findToyMoByModelKey(modelKey);
		if (originalToy == null) {
			throw new CustomValidatorCodeErrorException();
		}

		toyUpdatePersistenceIDTO.getToy().setId(originalToy.getId());

		ToyMO toy = repository.save(toyUpdatePersistenceIDTO.getToy());

		createAndCommitAuditChange(toy);

		return transformer.toToyPersistenceODTO(toy);
	}


	private void createAndCommitAuditChange(ToyMO toyMO) {

		String modelKey = Optional.ofNullable(toyMO).map(ToyMO::getModelKey)
			.orElse(Strings.EMPTY);

		Map<String, String> commitProperties = ImmutableMap.of(MODEL_KEY_COMMIT_KEY, modelKey);

		javers.commit(authorProvider.provide(), toyMO, commitProperties);

	}

}
