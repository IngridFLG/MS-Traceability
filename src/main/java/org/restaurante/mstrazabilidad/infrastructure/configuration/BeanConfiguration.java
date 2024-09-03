package org.restaurante.mstrazabilidad.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.restaurante.mstrazabilidad.domain.api.ITraceabilityServicePort;
import org.restaurante.mstrazabilidad.domain.spi.ITraceabilityPersistencePort;
import org.restaurante.mstrazabilidad.domain.usecase.TraceabilityUseCase;
import org.restaurante.mstrazabilidad.infrastructure.mongo.adapter.TraceabilityMongodbAdapter;
import org.restaurante.mstrazabilidad.infrastructure.mongo.mapper.TraceabilityEntityMapper;
import org.restaurante.mstrazabilidad.infrastructure.mongo.repository.ITraceabilityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITraceabilityRepository traceabilityRepository;
    private final TraceabilityEntityMapper traceabilityEntityMapper;

    @Bean
    public ITraceabilityPersistencePort traceabilityPersistencePort() {
        return new TraceabilityMongodbAdapter(traceabilityRepository, traceabilityEntityMapper);
    }

    @Bean
    public ITraceabilityServicePort traceabilityServicePort() {
        return new TraceabilityUseCase(traceabilityPersistencePort());
    }
}
