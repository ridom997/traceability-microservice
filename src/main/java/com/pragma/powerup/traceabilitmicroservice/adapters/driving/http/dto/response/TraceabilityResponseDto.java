package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TraceabilityResponseDto {
    private Long id;
    private Long idOrder;
    private Long idClient;
    private String mailClient;
    private Integer previousStatus;
    private Integer newStatus;
    private Long idEmployee;
    private String mailEmployee;
    private LocalDateTime date;
}
