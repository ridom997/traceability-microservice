package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.request.OrderLogDto;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.handlers.ITraceabilityHandler;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.mapper.request.DomainMapper;
import com.pragma.powerup.traceabilitmicroservice.domain.api.ITraceabilityServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class TraceabilityHandlerImpl implements ITraceabilityHandler {
    private final ITraceabilityServicePort traceabilityServicePort;
    private final DomainMapper domainMapper;

    @Override
    public void saveLog(OrderLogDto orderLogDto) {
        traceabilityServicePort.saveTraceabilityOfOrder(domainMapper.toTraceability(orderLogDto));
    }
}
