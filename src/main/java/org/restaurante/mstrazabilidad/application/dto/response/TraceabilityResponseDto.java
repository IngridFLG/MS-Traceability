package org.restaurante.mstrazabilidad.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TraceabilityResponseDto {

    private String state;

    private Date changeStateOrder;

    private Long orderId;
}
