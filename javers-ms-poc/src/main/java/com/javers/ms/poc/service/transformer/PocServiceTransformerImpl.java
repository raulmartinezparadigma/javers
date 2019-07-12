package com.javers.ms.poc.service.transformer;

import com.javers.libs.persistence.toy.service.dto.input.ToyCreatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.input.ToyUpdatePersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.output.audit.AuditPersistenceODTO;
import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import com.javers.ms.poc.service.dto.input.PocUpdateIDTO;
import com.javers.ms.poc.service.dto.output.ToyChangeODTO;
import com.javers.ms.poc.service.transformer.mapper.PocServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PocServiceTransformerImpl implements PocServiceTransformer {

    @Autowired
    private PocServiceMapper pocServiceMapper;


    @Override
    public ToyCreatePersistenceIDTO toToyPersistenceIDTO(PocCreateIDTO pocCreateIDTO) {
        return ToyCreatePersistenceIDTO.builder()
                .toy(pocCreateIDTO.getToy())
                .build();
    }

    @Override
    public ToyUpdatePersistenceIDTO toToyUpdatePersistenceIDTO(PocUpdateIDTO pocUpdateIDTO) {
        return ToyUpdatePersistenceIDTO.builder()
                .toy(pocUpdateIDTO.getToy())
                .build();
    }

    @Override
    public ToyChangeODTO toToyChangeODTO(AuditPersistenceODTO auditPersistenceODTO) {
        return ToyChangeODTO.builder().toyChanges(auditPersistenceODTO.getAuditChanges()).build();
    }
}
