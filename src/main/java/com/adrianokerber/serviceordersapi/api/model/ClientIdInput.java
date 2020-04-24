package com.adrianokerber.serviceordersapi.api.model;

import javax.validation.constraints.NotNull;

public class ClientIdInput {

    @NotNull
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}