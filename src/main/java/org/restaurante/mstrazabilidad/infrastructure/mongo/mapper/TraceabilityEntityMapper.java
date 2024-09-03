package org.restaurante.mstrazabilidad.infrastructure.mongo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.restaurante.mstrazabilidad.domain.model.TraceabilityModel;
import org.restaurante.mstrazabilidad.infrastructure.mongo.entity.TraceabilityEntity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraceabilityEntityMapper {

    TraceabilityEntity toTraceabilityEntity(TraceabilityModel traceabilityModel);

    TraceabilityModel toTraceabilityModel(TraceabilityEntity traceabilityEntity);

    List<TraceabilityModel> toTraceabilityModelList(List<TraceabilityEntity> traceabilityEntities);
}
