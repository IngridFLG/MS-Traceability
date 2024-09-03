package org.restaurante.mstrazabilidad.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.restaurante.mstrazabilidad.application.dto.request.TraceabilityRequestDto;
import org.restaurante.mstrazabilidad.application.dto.response.ListDurationAvgEmployeeResponseDto;
import org.restaurante.mstrazabilidad.application.dto.response.ListTraceabilityResponseDto;
import org.restaurante.mstrazabilidad.application.dto.response.TraceabilityResponseDto;
import org.restaurante.mstrazabilidad.application.handler.interfaces.ITraceabilityHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traceability")
@RequiredArgsConstructor
public class TraceabilityRestController {

    private final ITraceabilityHandler traceabilityHandler;

    @PostMapping("/save")
    public ResponseEntity<Void> saveTraceability(@Valid @RequestBody TraceabilityRequestDto traceabilityRequestDto) {
        traceabilityHandler.saveTraceability(traceabilityRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<List<TraceabilityResponseDto>> getAllTraceability(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(traceabilityHandler.getTraceability(orderId));
    }

    @GetMapping("/order/startEnd/{restaurantId}")
    public ResponseEntity<List<ListTraceabilityResponseDto>> getOrderStartAndEnd(@PathVariable("restaurantId") Long restaurantId) {
        return ResponseEntity.status(HttpStatus.OK).body(traceabilityHandler.getOrderStartAndEnd(restaurantId));
    }

    @GetMapping("/order/average/{restaurantId}")
    public ResponseEntity<List<ListDurationAvgEmployeeResponseDto>> getEmployeeAvg(@PathVariable("restaurantId") Long restaurantId) {
        return ResponseEntity.status(HttpStatus.OK).body(traceabilityHandler.getDurationAvgEmployee(restaurantId));
    }
}
