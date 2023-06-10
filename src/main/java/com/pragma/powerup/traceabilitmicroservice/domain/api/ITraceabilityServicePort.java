package com.pragma.powerup.traceabilitmicroservice.domain.api;

import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;

public interface ITraceabilityServicePort {
    void saveTraceabilityOfOrder(Traceability traceability);

}
