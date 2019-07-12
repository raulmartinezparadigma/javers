package com.javers.ms.poc.service.transformer;

import com.javers.libs.persistence.toy.service.dto.input.ToyCreatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.input.ToyUpdatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.output.audit.AuditPersistenceODTO;
import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import com.javers.ms.poc.service.dto.input.PocUpdateIDTO;
import com.javers.ms.poc.service.dto.output.ToyChangeODTO;

/**
 * Transformer entre la capa service y la librería del backend
 */
public interface PocServiceTransformer {


    ToyCreatePersistenceIDTO toToyPersistenceIDTO(PocCreateIDTO pocCreateIDTO);

    ToyUpdatePersistenceIDTO toToyUpdatePersistenceIDTO(PocUpdateIDTO pocUpdateIDTO);

    ToyChangeODTO toToyChangeODTO(AuditPersistenceODTO statusChangesPersistenceODTO);

}
