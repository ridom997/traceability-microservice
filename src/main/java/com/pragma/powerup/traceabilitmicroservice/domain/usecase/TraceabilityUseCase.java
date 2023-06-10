package com.pragma.powerup.traceabilitmicroservice.domain.usecase;

import com.pragma.powerup.traceabilitmicroservice.domain.api.ITraceabilityServicePort;
import com.pragma.powerup.traceabilitmicroservice.domain.exceptions.FailValidatingRequiredVariableException;
import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;
import com.pragma.powerup.traceabilitmicroservice.domain.spi.ITraceabilityPersistencePort;

import static com.pragma.powerup.traceabilitmicroservice.domain.utils.LongUtils.makeRandomId;

public class TraceabilityUseCase implements ITraceabilityServicePort{

    private final ITraceabilityPersistencePort traceabilityPersistencePort;



    public TraceabilityUseCase(ITraceabilityPersistencePort traceabilityPersistencePort) {
        this.traceabilityPersistencePort = traceabilityPersistencePort;
    }

    @Override
    public void saveTraceabilityOfOrder(Traceability traceability) {
        if (traceability.getNewStatus().equals(traceability.getPreviousStatus()))
            throw new FailValidatingRequiredVariableException("Both status are the same");
        traceability.setId(makeRandomId());
        traceabilityPersistencePort.saveTraceability(traceability);
    }
}
