package org.restaurante.mstrazabilidad.infrastructure.mongo.adapter;

import lombok.RequiredArgsConstructor;
import org.restaurante.mstrazabilidad.domain.model.TraceabilityModel;
import org.restaurante.mstrazabilidad.domain.spi.ITraceabilityPersistencePort;
import org.restaurante.mstrazabilidad.infrastructure.mongo.mapper.TraceabilityEntityMapper;
import org.restaurante.mstrazabilidad.infrastructure.mongo.repository.ITraceabilityRepository;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class TraceabilityMongodbAdapter implements ITraceabilityPersistencePort {

    private final ITraceabilityRepository traceabilityRepository;
    private final TraceabilityEntityMapper traceabilityEntityMapper;

    @Override
    public void saveTraceability(TraceabilityModel traceability) {
        traceabilityRepository.save(traceabilityEntityMapper.toTraceabilityEntity(traceability));
    }

    @Override
    public List<TraceabilityModel> getTraceability(Long orderId) {
        return traceabilityEntityMapper.toTraceabilityModelList(traceabilityRepository.findByOrderId(orderId));
    }

    @Override
    public List<TraceabilityModel> getOrderStartAndEnd(Long restaurantId) {
        List<String> states = Arrays.asList("DELIVERED", "CANCEL");
        Sort sort = Sort.by(Sort.Order.asc("orderId"), Sort.Order.asc("changeStateOrder"));
        return traceabilityEntityMapper.toTraceabilityModelList(traceabilityRepository.findAllByRestaurantIdAndStateIn(restaurantId, states, sort));
    }

    @Override
    public TraceabilityModel getTraceabilityOrderAndState(Long orderId, String state) {
        return traceabilityEntityMapper.toTraceabilityModel(traceabilityRepository.findByOrderIdAndState(orderId, state));
    }

    @Override
    public List<TraceabilityModel> getDurationAvgEmployee(Long restaurantId) {
        List<String> states = Arrays.asList("DELIVERED");
        Sort sort = Sort.by(Sort.Order.asc("duration"), Sort.Order.asc("changeStateOrder"));
        return traceabilityEntityMapper.toTraceabilityModelList(traceabilityRepository.findAllByRestaurantIdAndStateIn(restaurantId, states, sort));
    }
}
