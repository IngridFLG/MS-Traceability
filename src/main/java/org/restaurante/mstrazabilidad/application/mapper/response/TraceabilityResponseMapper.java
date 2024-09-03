package org.restaurante.mstrazabilidad.application.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.restaurante.mstrazabilidad.application.dto.response.TraceabilityResponseDto;
import org.restaurante.mstrazabilidad.domain.model.TraceabilityModel;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraceabilityResponseMapper {

    List<TraceabilityResponseDto> toTraceabilityResponseDto(List<TraceabilityModel> traceabilityModel);
}
