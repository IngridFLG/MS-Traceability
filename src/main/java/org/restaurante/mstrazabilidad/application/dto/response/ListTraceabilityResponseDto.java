package org.restaurante.mstrazabilidad.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListTraceabilityResponseDto {

    private Long orderId;

    private String duration;
}
