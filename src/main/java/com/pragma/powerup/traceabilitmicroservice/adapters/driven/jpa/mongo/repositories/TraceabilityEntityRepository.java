package com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.repositories;

import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.entity.TraceabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TraceabilityEntityRepository extends MongoRepository<TraceabilityEntity,Integer> {
    List<TraceabilityEntity> findAllByIdOrder(Long idOrder);

}
