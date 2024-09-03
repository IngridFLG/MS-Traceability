package org.restaurante.mstrazabilidad.infrastructure.mongo.repository;

import org.restaurante.mstrazabilidad.infrastructure.mongo.entity.TraceabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ITraceabilityRepository extends MongoRepository<TraceabilityEntity, String> {

    List<TraceabilityEntity> findByOrderId(Long orderId);

    List<TraceabilityEntity> findAllByRestaurantIdAndStateIn(Long restaurantId, List<String> states, Sort sort);

    TraceabilityEntity findByOrderIdAndState(Long orderId, String state);

}
