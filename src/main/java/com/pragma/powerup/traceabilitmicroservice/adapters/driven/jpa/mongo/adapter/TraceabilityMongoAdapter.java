package com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.adapter;

import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.entity.TraceabilityEntity;
import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.mappers.TraceabilityMapper;
import com.pragma.powerup.traceabilitmicroservice.adapters.driven.jpa.mongo.repositories.TraceabilityEntityRepository;
import com.pragma.powerup.traceabilitmicroservice.domain.model.Traceability;
import com.pragma.powerup.traceabilitmicroservice.domain.spi.ITraceabilityPersistencePort;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class TraceabilityMongoAdapter implements ITraceabilityPersistencePort {

    private final TraceabilityMapper traceabilityMapper;
    private final TraceabilityEntityRepository traceabilityEntityRepository;

    @Override
    public void saveTraceability(Traceability traceability) {
        traceabilityEntityRepository.save(traceabilityMapper.toEntity(traceability));
    }

    @Override
    public List<Traceability> getTraceabilityListOfOrder(Long idOrder) {
        List<Traceability> traceabilityList = new ArrayList<>();
        List<TraceabilityEntity> traceabilityEntityList = traceabilityEntityRepository.findAllByIdOrder(idOrder);
        if(!traceabilityEntityList.isEmpty())
            traceabilityEntityList.stream()
                    .map(traceabilityMapper::toDomain)
                    .forEach(traceabilityList::add);
        return traceabilityList;
    }
}
