package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.mapper.request;

import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.request.OrderLogDto;
import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DomainMapper {
    Traceability toTraceability(OrderLogDto orderLogDto);
}
