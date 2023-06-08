package com.pragma.powerup.traceabilitmicroservice.domain.exceptions;

public class FailValidatingRequiredVariableException extends RuntimeException{
    public FailValidatingRequiredVariableException(String message) {
        super(message);
    }
}
