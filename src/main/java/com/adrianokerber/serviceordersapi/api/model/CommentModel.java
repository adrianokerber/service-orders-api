package com.adrianokerber.serviceordersapi.api.model;

import java.time.OffsetDateTime;

public class CommentModel {

    private Long id;
    private String description;
    private OffsetDateTime creationDate;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

}