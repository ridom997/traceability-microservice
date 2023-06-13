package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.request.OrderLogDto;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.response.TraceabilityResponseDto;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.handlers.ITraceabilityHandler;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.mapper.request.TraceabilityRequestMapper;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.mapper.response.TraceabilityResponseMapper;
import com.pragma.powerup.traceabilitmicroservice.domain.api.ITraceabilityServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class TraceabilityHandlerImpl implements ITraceabilityHandler {
    private final ITraceabilityServicePort traceabilityServicePort;
    private final TraceabilityRequestMapper traceabilityRequestMapper;
    private final TraceabilityResponseMapper traceabilityResponseMapper;

    @Override
    public void saveLog(OrderLogDto orderLogDto) {
        traceabilityServicePort.saveTraceabilityOfOrder(traceabilityRequestMapper.toTraceability(orderLogDto));
    }

    @Override
    public List<TraceabilityResponseDto> getTraceabilityListOfOrder(Long idOrder) {
        return traceabilityServicePort.getTraceabilityListOfOrder(idOrder).stream()
                .map(traceabilityResponseMapper::toTraceabilityResponseDto)
                .toList();
    }
}
