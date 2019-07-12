package com.javers.ms.poc.service;

import com.javers.libs.persistence.toy.service.ToyPersistenceService;
import com.javers.libs.persistence.toy.service.audit.ToyAuditPersistenceService;
import com.javers.libs.persistence.toy.service.dto.input.ToyUpdatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.input.audit.ToyChangesAuditPersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.output.audit.AuditPersistenceODTO;
import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import com.javers.ms.poc.service.dto.input.PocUpdateIDTO;
import com.javers.ms.poc.service.dto.input.ToyChangeIDTO;
import com.javers.ms.poc.service.dto.output.ToyChangeODTO;
import com.javers.ms.poc.service.transformer.PocServiceTransformer;
import com.satelite.spring.libs.validation.MyValidator;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PocServiceImpl implements PocService {


    @Autowired
    private PocServiceTransformer pocServiceTransformer;

    @Autowired
    private ToyPersistenceService toyPersistenceService;

    @Autowired
    private ToyAuditPersistenceService toyAuditPersistenceService;

    @Override
    public void createPoc(@MyValidator PocCreateIDTO pocCreateIDTO) {
        Validate.notNull(pocCreateIDTO, "pocCreateIDTO null not allowed");
        toyPersistenceService.createToy(pocServiceTransformer.toToyPersistenceIDTO(pocCreateIDTO));
    }

    @Override
    public void updateToy(String modelKey, PocUpdateIDTO pocUpdateIDTO) {
        Validate.notNull(pocUpdateIDTO, "pocUpdateIDTO null not allowed");

        ToyUpdatePersistenceIDTO updatePersistenceIDTO = pocServiceTransformer.toToyUpdatePersistenceIDTO(pocUpdateIDTO);

        toyPersistenceService.updateToy(modelKey, updatePersistenceIDTO);
    }

    @Override
    public ToyChangeODTO getToyChanges(ToyChangeIDTO toyChangeIDTO) {
        //@off
        ToyChangesAuditPersistenceIDTO persistenceIDTO = ToyChangesAuditPersistenceIDTO.builder()
                .modelKey(toyChangeIDTO.getModelKey())
                .changesFrom(toyChangeIDTO.getChangesFrom())
                .changesTo(toyChangeIDTO.getChangesTo())
                .propertyToShow(toyChangeIDTO.getPropertyToShow())
                .build();
        //@on

        AuditPersistenceODTO auditPersistenceODTO = toyAuditPersistenceService.findChanges(persistenceIDTO);

        return pocServiceTransformer.toToyChangeODTO(auditPersistenceODTO);
    }
}
