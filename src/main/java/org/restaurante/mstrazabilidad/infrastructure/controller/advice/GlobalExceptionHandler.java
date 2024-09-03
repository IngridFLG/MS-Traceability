package org.restaurante.mstrazabilidad.infrastructure.controller.advice;

import org.restaurante.mstrazabilidad.application.dto.response.GenericResponseDto;
import org.restaurante.mstrazabilidad.domain.Exception.EmployeeOrderTraceabilityException;
import org.restaurante.mstrazabilidad.infrastructure.configuration.exception.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<GenericResponseDto> handleException(Exception ex) {
        GenericResponseDto response = new GenericResponseDto();
        response.setMsg(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler({JwtException.class})
    public ResponseEntity<GenericResponseDto> jwtException(JwtException ex) {
        GenericResponseDto response = new GenericResponseDto();
        response.setMsg(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({EmployeeOrderTraceabilityException.class})
    public ResponseEntity<GenericResponseDto> employeeOrderTraceabilityException(EmployeeOrderTraceabilityException ex) {
        GenericResponseDto response = new GenericResponseDto();
        response.setMsg(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
