package org.restaurante.mstrazabilidad.domain.spi;

import org.restaurante.mstrazabilidad.domain.model.TraceabilityModel;

import java.util.List;

public interface ITraceabilityPersistencePort {

    void saveTraceability(TraceabilityModel traceability);

    List<TraceabilityModel> getTraceability(Long orderId);

    List<TraceabilityModel> getOrderStartAndEnd(Long restaurantId);

    TraceabilityModel getTraceabilityOrderAndState(Long orderId, String state);

    List<TraceabilityModel> getDurationAvgEmployee(Long restaurantId);
}
