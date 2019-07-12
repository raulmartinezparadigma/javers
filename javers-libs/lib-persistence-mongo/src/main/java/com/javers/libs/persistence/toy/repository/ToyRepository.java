package com.javers.libs.persistence.toy.repository;

import com.javers.libs.persistence.toy.model.ToyMO;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ToyRepository extends MongoRepository<ToyMO, String>  {

    ToyMO findToyMoByModelKey(String modelKey);

}
