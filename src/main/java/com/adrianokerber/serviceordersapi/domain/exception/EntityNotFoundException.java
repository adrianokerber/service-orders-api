package com.adrianokerber.serviceordersapi.domain.exception;

public class EntityNotFoundException extends BusinessLogicException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }

}