package org.restaurante.mstrazabilidad.application.handler;

import lombok.RequiredArgsConstructor;
import org.restaurante.mstrazabilidad.application.dto.request.TraceabilityRequestDto;
import org.restaurante.mstrazabilidad.application.dto.response.ListDurationAvgEmployeeResponseDto;
import org.restaurante.mstrazabilidad.application.dto.response.ListTraceabilityResponseDto;
import org.restaurante.mstrazabilidad.application.dto.response.TraceabilityResponseDto;
import org.restaurante.mstrazabilidad.application.handler.interfaces.ITraceabilityHandler;
import org.restaurante.mstrazabilidad.application.mapper.request.TraceabilityRequestMapper;
import org.restaurante.mstrazabilidad.application.mapper.response.ListDurationAvgEmployeeResponseMapper;
import org.restaurante.mstrazabilidad.application.mapper.response.ListTraceabilityResponseMapper;
import org.restaurante.mstrazabilidad.application.mapper.response.TraceabilityResponseMapper;
import org.restaurante.mstrazabilidad.domain.api.ITraceabilityServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraceabilityHandler implements ITraceabilityHandler {

    private final ITraceabilityServicePort traceabilityServicePort;
    private final TraceabilityRequestMapper traceabilityRequestMapper;
    private final TraceabilityResponseMapper traceabilityResponseMapper;
    private final ListTraceabilityResponseMapper listTraceabilityResponseMapper;
    private final ListDurationAvgEmployeeResponseMapper listDurationAvgEmployeeResponseMapper;

    @Override
    public void saveTraceability(TraceabilityRequestDto traceabilityRequestDto) {
        traceabilityServicePort.saveTraceability(traceabilityRequestMapper.toTraceabilityModel(traceabilityRequestDto));
    }

    @Override
    public List<TraceabilityResponseDto> getTraceability(Long orderId) {
        return traceabilityResponseMapper.toTraceabilityResponseDto(traceabilityServicePort.getTraceability(orderId));
    }

    @Override
    public List<ListTraceabilityResponseDto> getOrderStartAndEnd(Long restaurantId) {
        return listTraceabilityResponseMapper.toListTraceabilityResponseDto(traceabilityServicePort.getOrderStartAndEnd(restaurantId));
    }

    @Override
    public List<ListDurationAvgEmployeeResponseDto> getDurationAvgEmployee(Long restaurantId) {
        return  listDurationAvgEmployeeResponseMapper.toDtoList(traceabilityServicePort.getDurationAvgEmployee(restaurantId));
    }
}
