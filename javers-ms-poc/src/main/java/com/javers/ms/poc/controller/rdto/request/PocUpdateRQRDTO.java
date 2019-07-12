package com.javers.ms.poc.controller.rdto.request;

import com.javers.libs.persistence.toy.model.ToyMO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PocUpdateRQRDTO {

    @NotNull
    private ToyMO toy;

}
