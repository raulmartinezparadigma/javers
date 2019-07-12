package com.javers.ms.poc.controller.transformer;

import com.javers.ms.poc.controller.rdto.request.AuditRQRDTO;
import com.javers.ms.poc.controller.rdto.request.PocCreateRQRDTO;
import com.javers.ms.poc.controller.rdto.request.PocUpdateRQRDTO;
import com.javers.ms.poc.controller.rdto.response.ToyChangeRSDTO;
import com.javers.ms.poc.controller.rdto.response.ToyChangesRSDTO;
import com.javers.ms.poc.controller.transformer.mapper.PocControllerMapper;
import com.javers.ms.poc.service.PocService;
import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import com.javers.ms.poc.service.dto.input.PocUpdateIDTO;
import com.javers.ms.poc.service.dto.input.ToyChangeIDTO;
import com.javers.ms.poc.service.dto.output.ToyChangeODTO;
import org.apache.commons.lang3.Validate;
import org.javers.core.commit.CommitMetadata;
import org.javers.core.diff.changetype.ValueChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.javers.libs.persistence.toy.service.ToyPersistenceServiceImpl.MODEL_KEY_COMMIT_KEY;

@Service
public class PocControllerTransformerImpl implements PocControllerTransformer {

    @Autowired
    private PocControllerMapper pocControllerMapper;

    @Autowired
    private PocService pocService;

    @Override
    public PocCreateIDTO toPocCreateIDTO(PocCreateRQRDTO pocCreateRQRDTO) {
        Validate.notNull(pocCreateRQRDTO, "pocCreateRQRDTO null not allowed");

        PocCreateIDTO pocCreateIDTO = pocControllerMapper.toPocCreateIDTO(pocCreateRQRDTO);
        //pocService


        return pocCreateIDTO;
    }

    @Override
    public PocUpdateIDTO toPocUpdateIDTO(PocUpdateRQRDTO pocUpdateRQRDTO) {
        Validate.notNull(pocUpdateRQRDTO, "pocUpdateRQRDTO null not allowed");

        PocUpdateIDTO pocUpdateIDTO = pocControllerMapper.toPocUpdateIDTO(pocUpdateRQRDTO);


        return pocUpdateIDTO;
    }

    @Override
    public ToyChangeIDTO toToyChangeIDTO(AuditRQRDTO orderAuditParams, String modelKey) {

        LocalDateTime fromLocalDateTime = Objects.nonNull(orderAuditParams.getChangesFrom()) ? LocalDateTime.ofInstant(Instant.ofEpochMilli(orderAuditParams.getChangesFrom()), ZoneId.systemDefault()) : null;
        LocalDateTime toLocalDateTime = Objects.nonNull(orderAuditParams.getChangesTo()) ? LocalDateTime.ofInstant(Instant.ofEpochMilli(orderAuditParams.getChangesTo()), ZoneId.systemDefault()) : null;
        ToyChangeIDTO idto = ToyChangeIDTO.builder() //@off
                .modelKey(modelKey)
                .changesFrom(fromLocalDateTime)
                .changesTo(toLocalDateTime)
                .propertyToShow(orderAuditParams.getAuditedProperty())
                .build(); //@on

        return idto;
    }

    @Override
    public ToyChangesRSDTO toToyChangesRSDTO(ToyChangeODTO toyChangeODTO) {
        List<ToyChangeRSDTO> responseChanges = toyChangeODTO.getToyChanges().stream()
                .filter(ValueChange.class::isInstance)
                .map(ValueChange.class::cast)
                .map(this::serviceChangeToResponse)
                .collect(Collectors.toList());

        return ToyChangesRSDTO.builder()
                .changes(responseChanges)
                .build();

    }

    private ToyChangeRSDTO serviceChangeToResponse(ValueChange change) {


        return ToyChangeRSDTO.builder()
                .author(change.getCommitMetadata().map(CommitMetadata::getAuthor).orElse(null))
                .commitId(change.getCommitMetadata().map(CommitMetadata::getId).map(id -> id.valueAsNumber().doubleValue()).orElse(null))
                .changeDate(change.getCommitMetadata().map(CommitMetadata::getCommitDate).map(date -> OffsetDateTime.of(date, ZoneOffset.UTC)).orElse(null))
                .statusChangedFrom(change.getLeft().toString())
                .statusChangedTo(change.getRight().toString())
                .modelKey(change.getCommitMetadata().map(CommitMetadata::getProperties).map(map -> map.get(MODEL_KEY_COMMIT_KEY)).orElse(null))
                .build();
    }


    private Long offsetDateToLong(OffsetDateTime date) {

        if (Objects.nonNull(date)) {
            return date.toEpochSecond();
        }

        return null;
    }


}
