package org.restaurante.mstrazabilidad.application.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.restaurante.mstrazabilidad.application.dto.request.TraceabilityRequestDto;
import org.restaurante.mstrazabilidad.domain.model.TraceabilityModel;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraceabilityRequestMapper {

    TraceabilityModel toTraceabilityModel(TraceabilityRequestDto traceabilityRequestDto);

}
