package com.adrianokerber.serviceordersapi.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.adrianokerber.serviceordersapi.domain.model.ServiceOrderStatus;

public class ServiceOrderModel {

    private Long id;
    private ClientPreviewModel client;
    private String description;
    private BigDecimal price;
    private ServiceOrderStatus status;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientPreviewModel getClient() {
        return this.client;
    }

    public void setClient(ClientPreviewModel client) {
        this.client = client;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ServiceOrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(ServiceOrderStatus status) {
        this.status = status;
    }

    public OffsetDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

}