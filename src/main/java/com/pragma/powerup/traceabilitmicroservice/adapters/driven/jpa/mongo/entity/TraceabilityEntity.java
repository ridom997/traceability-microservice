package com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@Document(collection = "Traceability")
public class TraceabilityEntity {
    @Id
    private Long id;
    private Long idOrder;
    private Long idClient;
    private String mailClient;
    private LocalDateTime date;
    private Integer previousStatus;
    private Integer newStatus;
    private Long idEmployee;
    private String mailEmployee;
}
