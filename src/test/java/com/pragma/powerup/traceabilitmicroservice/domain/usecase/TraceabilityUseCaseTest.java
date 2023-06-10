package com.pragma.powerup.traceabilitmicroservice.domain.usecase;

import com.pragma.powerup.traceabilitmicroservice.domain.api.ITraceabilityServicePort;
import com.pragma.powerup.traceabilitmicroservice.domain.exceptions.FailValidatingRequiredVariableException;
import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;
import com.pragma.powerup.traceabilitmicroservice.domain.spi.ITraceabilityPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TraceabilityUseCaseTest {

    @Mock
    private ITraceabilityPersistencePort traceabilityPersistencePort;

    @InjectMocks
    private TraceabilityUseCase traceabilityUseCase;

    @Test
    void saveTraceabilityOfOrder_shouldSaveTraceabilityWithRandomId() {
        // Arrange
        Traceability traceability = new Traceability();
        traceability.setNewStatus(1);
        traceability.setPreviousStatus(1);

        // Act
        assertThrows(FailValidatingRequiredVariableException.class, () -> traceabilityUseCase.saveTraceabilityOfOrder(traceability));

        // Assert
        verify(traceabilityPersistencePort, times(0)).saveTraceability(traceability);
    }

    @Test
    void saveTraceabilityOfOrder_successfully() {
        // Arrange
        Traceability traceability = new Traceability();
        traceability.setPreviousStatus(1);
        traceability.setNewStatus(2);

        // Act
        traceabilityUseCase.saveTraceabilityOfOrder(traceability);

        // Assert
        assertNotNull(traceability.getId());
        verify(traceabilityPersistencePort, times(1)).saveTraceability(traceability);
    }

    @Test
    void saveTraceabilityOfOrder_failCreatingId() {
        // Arrange
        Traceability traceability = new Traceability();
        traceability.setPreviousStatus(1);
        traceability.setNewStatus(2);

        // Act
        traceabilityUseCase.saveTraceabilityOfOrder(traceability);

        // Assert
        assertNotNull(traceability.getId());
        verify(traceabilityPersistencePort, times(1)).saveTraceability(traceability);
    }
}