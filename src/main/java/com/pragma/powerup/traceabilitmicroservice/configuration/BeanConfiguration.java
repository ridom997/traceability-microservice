package com.pragma.powerup.traceabilitmicroservice.configuration;

import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.adapter.TraceabilityMongoAdapter;
import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.mappers.TraceabilityMapper;
import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.repositories.TraceabilityEntityRepository;
import com.pragma.powerup.traceabilitmicroservice.domain.api.ITraceabilityServicePort;
import com.pragma.powerup.traceabilitmicroservice.domain.spi.ITraceabilityPersistencePort;
import com.pragma.powerup.traceabilitmicroservice.domain.usecase.TraceabilityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final TraceabilityEntityRepository traceabilityEntityRepository;
    private final TraceabilityMapper traceabilityMapper;


    @Bean
    public ITraceabilityPersistencePort traceabilityPersistencePort(){
        return new TraceabilityMongoAdapter(traceabilityMapper,traceabilityEntityRepository);
    }

    @Bean
    public ITraceabilityServicePort traceabilityServicePort(){
        return new TraceabilityUseCase(traceabilityPersistencePort());
    }

}
