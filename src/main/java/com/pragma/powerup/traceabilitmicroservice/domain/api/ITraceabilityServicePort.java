package com.pragma.powerup.traceabilitmicroservice.domain.api;

import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;

import java.util.List;

public interface ITraceabilityServicePort {
    void saveTraceabilityOfOrder(Traceability traceability);

    List<Traceability> getTraceabilityListOfOrder(Long idOrder);

}
