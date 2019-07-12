package com.javers.ms.poc.controller.transformer;

import com.javers.ms.poc.controller.rdto.request.AuditRQRDTO;
import com.javers.ms.poc.controller.rdto.request.PocCreateRQRDTO;
import com.javers.ms.poc.controller.rdto.request.PocUpdateRQRDTO;
import com.javers.ms.poc.controller.rdto.response.ToyChangesRSDTO;
import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import com.javers.ms.poc.service.dto.input.PocUpdateIDTO;
import com.javers.ms.poc.service.dto.input.ToyChangeIDTO;
import com.javers.ms.poc.service.dto.output.ToyChangeODTO;

/**
 * Transformer de Poc entre la capa REST y la capa de servicio
 */
public interface PocControllerTransformer {

    /**
     * Transforma el objeto de entrada de la capa REST al objeto de entrada al servicio
     */
    PocCreateIDTO toPocCreateIDTO(PocCreateRQRDTO pocCreateRQRDTO);

    PocUpdateIDTO toPocUpdateIDTO(PocUpdateRQRDTO pocUpdateRQRDTO);

    ToyChangeIDTO toToyChangeIDTO(AuditRQRDTO orderAuditParams, String modelKey);

    ToyChangesRSDTO toToyChangesRSDTO(ToyChangeODTO toyChangeODTO);

}
