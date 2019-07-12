package com.javers.ms.poc.controller;

import com.javers.ms.poc.controller.rdto.request.AuditRQRDTO;
import com.javers.ms.poc.controller.rdto.request.PocCreateRQRDTO;
import com.javers.ms.poc.controller.rdto.request.PocUpdateRQRDTO;
import com.javers.ms.poc.controller.rdto.response.ToyChangesRSDTO;
import com.javers.ms.poc.controller.transformer.PocControllerTransformer;
import com.javers.ms.poc.service.PocService;
import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import com.javers.ms.poc.service.dto.input.PocUpdateIDTO;
import com.javers.ms.poc.service.dto.input.ToyChangeIDTO;
import com.javers.ms.poc.service.dto.output.ToyChangeODTO;
import com.satelite.spring.libs.validation.MyValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * API para el microservicio de Poc
 */
@RestController
@CrossOrigin(origins = "*")
public class PocController {

    private static final Logger LOG = LoggerFactory.getLogger(PocController.class);

    /**
     * Path base de nuestro controlador
     */
    public static final String PATH = "/toys";

    @Autowired
    private PocService pocService;

    @Autowired
    private PocControllerTransformer pocControllerTransformer;

    @PostMapping(path = PATH)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createPoc(@RequestBody @MyValidator PocCreateRQRDTO pocCreateRQRDTO) {

        LOG.debug("Solicitada creación de poc: {} ", pocCreateRQRDTO);

        PocCreateIDTO pocCreateIDTO = pocControllerTransformer.toPocCreateIDTO(pocCreateRQRDTO);
        pocService.createPoc(pocCreateIDTO);

        LOG.debug("Finalizada creación del registro: {} ", pocCreateIDTO);

    }

    @PutMapping(PATH + "/{modelKey}")
    public void updateOrderRelease(@PathVariable("modelKey") String modelKey, //@off
                                   @RequestBody @MyValidator PocUpdateRQRDTO pocUpdateRQRDTO) { //@on

        LOG.debug("Solicitud de modificación de modelKey con id {}", modelKey);

        PocUpdateIDTO pocUpdateIDTO = pocControllerTransformer.toPocUpdateIDTO(pocUpdateRQRDTO);
        pocService.updateToy(modelKey, pocUpdateIDTO);

        LOG.debug("Toy modificado correctamente con id {}", modelKey);
    }

    @GetMapping(PATH + "/{modelKey}/audit")
    @ResponseStatus(value = HttpStatus.OK)
    public ToyChangesRSDTO auditToys(@PathVariable("modelKey") String modelKey,
                                     AuditRQRDTO orderAuditParams) {

        LOG.debug("Audit modelKey: {} ", modelKey);

        ToyChangeIDTO toyChangeIDTO = pocControllerTransformer.toToyChangeIDTO(orderAuditParams, modelKey);

        ToyChangeODTO toyChangeODTO = pocService.getToyChanges(toyChangeIDTO);

        return pocControllerTransformer.toToyChangesRSDTO(toyChangeODTO);

    }


}
