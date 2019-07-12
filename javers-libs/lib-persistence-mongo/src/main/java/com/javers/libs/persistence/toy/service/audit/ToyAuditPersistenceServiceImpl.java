package com.javers.libs.persistence.toy.service.audit;

import com.javers.libs.persistence.toy.model.ToyMO;
import com.javers.libs.persistence.toy.service.dto.input.audit.ToyChangesAuditPersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.output.audit.AuditPersistenceODTO;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.repository.jql.JqlQuery;
import org.javers.repository.jql.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToyAuditPersistenceServiceImpl implements ToyAuditPersistenceService {

    private static final Logger LOG = LoggerFactory.getLogger(ToyAuditPersistenceServiceImpl.class);

    private static final String MODEL_KEY_PROPERTY = "modelKey";

    @Autowired
    private Javers javers;


    @Override
    public AuditPersistenceODTO findChanges(ToyChangesAuditPersistenceIDTO idto) {
        JqlQuery colorChangesQuery = QueryBuilder.byClass(ToyMO.class)
                .from(idto.getChangesFrom())
                .to(idto.getChangesTo())
                .withCommitProperty(MODEL_KEY_PROPERTY, idto.getModelKey())
                .withChangedProperty(idto.getPropertyToShow())
                .withChildValueObjects()
                .build();

    return find(colorChangesQuery);
    }

    private AuditPersistenceODTO find(JqlQuery query) {

        Changes changes = javers.findChanges(query);

        LOG.debug(changes.prettyPrint());

        return AuditPersistenceODTO.builder()
                .auditChanges(changes)
                .build();
    }
}
