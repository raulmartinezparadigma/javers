package com.javers.libs.persistence.toy.service.audit;

import com.javers.libs.persistence.toy.service.dto.input.audit.ToyChangesAuditPersistenceIDTO;
import com.javers.libs.persistence.toy.service.dto.output.ToyPersistenceODTO;
import com.javers.libs.persistence.toy.service.dto.output.audit.AuditPersistenceODTO;

public interface ToyAuditPersistenceService {

    AuditPersistenceODTO findChanges(ToyChangesAuditPersistenceIDTO idto);


}
