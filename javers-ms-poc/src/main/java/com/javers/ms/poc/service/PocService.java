package com.javers.ms.poc.service;

import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import com.javers.ms.poc.service.dto.input.PocUpdateIDTO;
import com.javers.ms.poc.service.dto.input.ToyChangeIDTO;
import com.javers.ms.poc.service.dto.output.ToyChangeODTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servicio de Poc
 */
public interface PocService {

    Logger LOG = LoggerFactory.getLogger(PocService.class);

    void createPoc(PocCreateIDTO pocCreateIDTO);

    void updateToy(String modelKey, PocUpdateIDTO pocUpdateIDTO);

    ToyChangeODTO getToyChanges(ToyChangeIDTO toyChangeIDTO);
}
