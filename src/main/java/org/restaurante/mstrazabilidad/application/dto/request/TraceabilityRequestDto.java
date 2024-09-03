package org.restaurante.mstrazabilidad.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TraceabilityRequestDto {

    @NotBlank(message = "The state is required")
    private String state;

    @NotNull(message = "The orderId is required")
    private Long orderId;

    @NotNull(message = "The restaurantId is required")
    private Long restaurantId;

    private Long employeeId;

    @NotNull(message = "The changeStateOrder date is required")
    private Date changeStateOrder;
}
