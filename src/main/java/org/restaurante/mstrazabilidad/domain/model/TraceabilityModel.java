package org.restaurante.mstrazabilidad.domain.model;

import java.util.Date;

public class TraceabilityModel {

    private String id;

    private String state;

    private Long orderId;

    private Long restaurantId;

    private Long employeeId;

    private Date changeStateOrder;

    private String duration;

    public TraceabilityModel() {
    }

    public TraceabilityModel(String id, String state, Long orderId, Long restaurantId, Long employeeId, Date changeStateOrder, String duration) {
        this.id = id;
        this.state = state;
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.employeeId = employeeId;
        this.changeStateOrder = changeStateOrder;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getChangeStateOrder() {
        return changeStateOrder;
    }

    public void setChangeStateOrder(Date changeStateOrder) {
        this.changeStateOrder = changeStateOrder;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
