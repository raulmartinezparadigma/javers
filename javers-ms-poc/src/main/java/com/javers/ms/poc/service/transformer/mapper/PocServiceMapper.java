package com.javers.ms.poc.service.transformer.mapper;

import com.javers.libs.persistence.toy.model.ToyMO;
import com.javers.ms.poc.service.dto.input.PocCreateIDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PocServiceMapper {


    ToyMO toToyMO(PocCreateIDTO pocCreateIDTO);
}
