package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.request.OrderLogDto;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.response.TraceabilityResponseDto;

import java.util.List;

public interface ITraceabilityHandler {
    void saveLog(OrderLogDto orderLogDto);

    List<TraceabilityResponseDto> getTraceabilityListOfOrder(Long idOrder);
}
