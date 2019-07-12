package com.javers.ms.poc.controller.transformer.mapper;

import com.javers.ms.poc.controller.rdto.request.PocCreateRQRDTO;
import com.javers.ms.poc.controller.rdto.request.PocUpdateRQRDTO;
import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import com.javers.ms.poc.service.dto.input.PocUpdateIDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PocControllerMapper {

    PocCreateIDTO toPocCreateIDTO(PocCreateRQRDTO pocCreateRQRDTO);

    PocUpdateIDTO toPocUpdateIDTO(PocUpdateRQRDTO pocUpdateRQRDTO);
}
