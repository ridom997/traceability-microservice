package com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.mappers;

import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.entity.TraceabilityEntity;
import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TraceabilityMapper {
    TraceabilityEntity toEntity(Traceability traceability);

    Traceability toDomain(TraceabilityEntity traceabilityEntity);
}
