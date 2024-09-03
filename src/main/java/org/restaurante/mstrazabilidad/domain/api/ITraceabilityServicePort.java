package org.restaurante.mstrazabilidad.domain.api;

import org.restaurante.mstrazabilidad.domain.model.EmployeeAverage;
import org.restaurante.mstrazabilidad.domain.model.TraceabilityModel;

import java.util.List;

public interface ITraceabilityServicePort {

    void saveTraceability(TraceabilityModel traceability);

    List<TraceabilityModel> getTraceability(Long orderId);

    List<TraceabilityModel> getOrderStartAndEnd(Long restaurantId);

    List<EmployeeAverage> getDurationAvgEmployee(Long restaurantId);
}
