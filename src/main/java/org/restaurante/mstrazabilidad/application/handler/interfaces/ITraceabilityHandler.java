package org.restaurante.mstrazabilidad.application.handler.interfaces;

import org.restaurante.mstrazabilidad.application.dto.request.TraceabilityRequestDto;
import org.restaurante.mstrazabilidad.application.dto.response.ListDurationAvgEmployeeResponseDto;
import org.restaurante.mstrazabilidad.application.dto.response.ListTraceabilityResponseDto;
import org.restaurante.mstrazabilidad.application.dto.response.TraceabilityResponseDto;

import java.util.List;

public interface ITraceabilityHandler {

    void saveTraceability(TraceabilityRequestDto traceabilityRequestDto);

    List<TraceabilityResponseDto> getTraceability(Long orderId);

    List<ListTraceabilityResponseDto> getOrderStartAndEnd(Long restaurantId);

    List<ListDurationAvgEmployeeResponseDto> getDurationAvgEmployee(Long restaurantId);
}
