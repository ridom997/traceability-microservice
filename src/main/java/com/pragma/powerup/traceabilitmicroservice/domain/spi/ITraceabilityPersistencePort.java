package com.pragma.powerup.traceabilitmicroservice.domain.spi;

import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;

public interface ITraceabilityPersistencePort {
    void saveTraceability(Traceability traceability);
}
