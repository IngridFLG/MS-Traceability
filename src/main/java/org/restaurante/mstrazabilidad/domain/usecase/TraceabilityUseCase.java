package org.restaurante.mstrazabilidad.domain.usecase;

import org.restaurante.mstrazabilidad.domain.Exception.EmployeeOrderTraceabilityException;
import org.restaurante.mstrazabilidad.domain.api.ITraceabilityServicePort;
import org.restaurante.mstrazabilidad.domain.model.EmployeeAverage;
import org.restaurante.mstrazabilidad.domain.model.OrderAverage;
import org.restaurante.mstrazabilidad.domain.model.TraceabilityModel;
import org.restaurante.mstrazabilidad.domain.spi.ITraceabilityPersistencePort;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TraceabilityUseCase implements ITraceabilityServicePort {

    private final ITraceabilityPersistencePort traceabilityPersistencePort;

    public TraceabilityUseCase(ITraceabilityPersistencePort traceabilityPersistencePort) {
        this.traceabilityPersistencePort = traceabilityPersistencePort;
    }

    @Override
    public void saveTraceability(TraceabilityModel traceability) {
        if(!traceability.getState().equals("CANCEL") && !traceability.getState().equals("PENDING") && traceability.getEmployeeId() == null) {
            throw new EmployeeOrderTraceabilityException("The employee es required");
        }

        if(traceability.getState().equals("CANCEL") || traceability.getState().equals("DELIVERED")) {
            TraceabilityModel traceabilityModel = traceabilityPersistencePort.getTraceabilityOrderAndState(traceability.getOrderId(), "PENDING");

            // Calcular la duración entre el estado "PENDING" y el estado actual
            long durationMillis = traceability.getChangeStateOrder().getTime() - traceabilityModel.getChangeStateOrder().getTime();

            // Convertir milisegundos a horas, minutos y segundos
            long durationSeconds = TimeUnit.MILLISECONDS.toSeconds(durationMillis);
            long hours = TimeUnit.SECONDS.toHours(durationSeconds);
            long minutes = TimeUnit.SECONDS.toMinutes(durationSeconds) % 60;
            long seconds = durationSeconds % 60;

            // Formatear la duración como "HH:mm:ss"
            String durationFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            traceability.setDuration(durationFormatted);
        }
        traceabilityPersistencePort.saveTraceability(traceability);
    }

    @Override
    public List<TraceabilityModel> getTraceability(Long orderId) {
        return traceabilityPersistencePort.getTraceability(orderId);
    }

    @Override
    public List<TraceabilityModel> getOrderStartAndEnd(Long restaurantId) {
        return traceabilityPersistencePort.getOrderStartAndEnd(restaurantId);
    }

    @Override
    public List<EmployeeAverage> getDurationAvgEmployee(Long restaurantId) {
        // Obtiene todas las trazabilidades para el restaurante dado
        List<TraceabilityModel> traceabilityModels = traceabilityPersistencePort.getDurationAvgEmployee(restaurantId);

        System.out.println(traceabilityModels);

        // Mapa para agrupar las duraciones por empleado
        Map<Long, List<String>> employeeDurationsMap = new HashMap<>();

        // Agrupa las duraciones por empleado
        for (TraceabilityModel traceabilityModel : traceabilityModels) {
            if (traceabilityModel.getEmployeeId() != null) {
                employeeDurationsMap
                        .computeIfAbsent(traceabilityModel.getEmployeeId(), k -> new ArrayList<>())
                        .add(traceabilityModel.getDuration());
            }
        }

        // Lista para almacenar los promedios de duración por empleado
        List<EmployeeAverage> employeeAverages = new ArrayList<>();

        // Calcula el promedio de duración por empleado
        for (Map.Entry<Long, List<String>> entry : employeeDurationsMap.entrySet()) {
            Long employeeId = entry.getKey();
            List<String> durations = entry.getValue();

            // Convertir todas las duraciones a segundos
            long totalSeconds = 0;
            for (String duration : durations) {
                String[] parts = duration.split(":");
                long hours = Long.parseLong(parts[0]);
                long minutes = Long.parseLong(parts[1]);
                long seconds = Long.parseLong(parts[2]);

                totalSeconds += TimeUnit.HOURS.toSeconds(hours) + TimeUnit.MINUTES.toSeconds(minutes) + seconds;
            }

            // Calcular el promedio en segundos
            long averageSeconds = totalSeconds / durations.size();

            // Convertir el promedio de segundos de vuelta a "HH:mm:ss"
            long averageHours = TimeUnit.SECONDS.toHours(averageSeconds);
            long averageMinutes = TimeUnit.SECONDS.toMinutes(averageSeconds) % 60;
            long averageSecs = averageSeconds % 60;
            String averageFormatted = String.format("%02d:%02d:%02d", averageHours, averageMinutes, averageSecs);

            // Crea una lista de objetos OrderAverage
            List<OrderAverage> orderAverages = new ArrayList<>();
            for (TraceabilityModel traceabilityModel : traceabilityModels) {
                if (traceabilityModel.getEmployeeId().equals(employeeId)) {
                    orderAverages.add(new OrderAverage(traceabilityModel.getOrderId(), traceabilityModel.getDuration()));
                }
            }

            // Añade el promedio y las órdenes al objeto EmployeeAverage
            employeeAverages.add(new EmployeeAverage(employeeId, averageFormatted, orderAverages));
        }



        return employeeAverages;
    }
}
