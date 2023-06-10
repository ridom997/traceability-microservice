package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.request.OrderLogDto;

public interface ITraceabilityHandler {
    void saveLog(OrderLogDto orderLogDto);
}
