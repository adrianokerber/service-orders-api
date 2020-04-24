package com.adrianokerber.serviceordersapi.api.model;

import javax.validation.constraints.NotBlank;

public class CommentInput {

    @NotBlank
    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}