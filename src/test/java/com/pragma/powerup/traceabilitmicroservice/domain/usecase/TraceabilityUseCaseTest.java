package com.pragma.powerup.traceabilitmicroservice.domain.usecase;

import com.pragma.powerup.traceabilitmicroservice.domain.api.ITraceabilityServicePort;
import com.pragma.powerup.traceabilitmicroservice.domain.exceptions.FailValidatingRequiredVariableException;
import com.pragma.powerup.traceabilitmicroservice.domain.exceptions.NoDataFoundException;
import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;
import com.pragma.powerup.traceabilitmicroservice.domain.spi.ITraceabilityPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void getTraceabilityListOfOrder_successfully() {
        Long idOrder = 1L;
        List<Traceability> expectedList = List.of(new Traceability(), new Traceability());
        when(traceabilityPersistencePort.getTraceabilityListOfOrder(idOrder)).thenReturn(expectedList);

        List<Traceability> result = traceabilityUseCase.getTraceabilityListOfOrder(idOrder);

        assertEquals(expectedList, result);
    }

    @Test
    void getTraceabilityListOfOrder_emptyList() {
        Long idOrder = 1L;
        List<Traceability> expectedList = new ArrayList<>();
        when(traceabilityPersistencePort.getTraceabilityListOfOrder(idOrder)).thenReturn(expectedList);

        assertThrows(NoDataFoundException.class, () -> traceabilityUseCase.getTraceabilityListOfOrder(idOrder));
    }
}