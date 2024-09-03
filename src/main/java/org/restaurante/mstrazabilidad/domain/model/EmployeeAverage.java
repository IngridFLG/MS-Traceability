package org.restaurante.mstrazabilidad.domain.model;

import java.util.List;

public class EmployeeAverage {

    private Long employeeId;

    private String avg;

    private List<OrderAverage> orders;

    public EmployeeAverage() {
    }

    public EmployeeAverage(Long employeeId, String avg, List<OrderAverage> orders) {
        this.employeeId = employeeId;
        this.avg = avg;
        this.orders = orders;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public List<OrderAverage> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderAverage> orders) {
        this.orders = orders;
    }
}


