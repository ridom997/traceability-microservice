package com.pragma.powerup.traceabilitmicroservice.domain.spi;

import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;

import java.util.List;

public interface ITraceabilityPersistencePort {
    void saveTraceability(Traceability traceability);

    List<Traceability> getTraceabilityListOfOrder(Long idOrder);

}
