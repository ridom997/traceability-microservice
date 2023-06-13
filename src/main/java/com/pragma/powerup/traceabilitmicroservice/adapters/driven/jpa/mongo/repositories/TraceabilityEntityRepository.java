package com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.repositories;

import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.entity.TraceabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TraceabilityEntityRepository extends MongoRepository<TraceabilityEntity,Integer> {
    @Query("SELECT t FROM TraceabilityEntity t WHERE idOrder = :idOrder")
    List<TraceabilityEntity> findAllByIdOrder(Long idOrder);

}
