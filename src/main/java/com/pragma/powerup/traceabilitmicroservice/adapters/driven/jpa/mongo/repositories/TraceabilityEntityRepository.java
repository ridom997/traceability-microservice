package com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.repositories;

import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.entity.TraceabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TraceabilityEntityRepository extends MongoRepository<TraceabilityEntity,Integer> {
}
