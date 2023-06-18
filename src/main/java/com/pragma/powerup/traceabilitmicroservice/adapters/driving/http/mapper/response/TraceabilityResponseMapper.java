package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.mapper.response;

import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.response.TraceabilityResponseDto;
import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TraceabilityResponseMapper {
    TraceabilityResponseDto toTraceabilityResponseDto(Traceability traceability);
}
