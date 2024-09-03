package org.restaurante.mstrazabilidad.application.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.restaurante.mstrazabilidad.application.dto.response.ListDurationAvgEmployeeResponseDto;
import org.restaurante.mstrazabilidad.application.dto.response.ListTraceabilityResponseDto;
import org.restaurante.mstrazabilidad.domain.model.EmployeeAverage;
import org.restaurante.mstrazabilidad.domain.model.OrderAverage;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListDurationAvgEmployeeResponseMapper {

    @Mapping(source = "avg", target = "avg")
    @Mapping(source = "orders", target = "orders")
    ListDurationAvgEmployeeResponseDto toDto(EmployeeAverage employeeAverage);

    List<ListDurationAvgEmployeeResponseDto> toDtoList(List<EmployeeAverage> employeeAverages);

    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "duration", target = "duration")
    ListTraceabilityResponseDto toDto(OrderAverage orderAverage);

    List<ListTraceabilityResponseDto> toDtoOrderList(List<OrderAverage> orderAverages);
}
