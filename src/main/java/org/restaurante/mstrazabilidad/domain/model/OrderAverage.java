package org.restaurante.mstrazabilidad.domain.model;

public class OrderAverage {

    private Long orderId;

    private String duration;

    public OrderAverage() {
    }

    public OrderAverage(Long orderId, String duration) {
        this.orderId = orderId;
        this.duration = duration;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
