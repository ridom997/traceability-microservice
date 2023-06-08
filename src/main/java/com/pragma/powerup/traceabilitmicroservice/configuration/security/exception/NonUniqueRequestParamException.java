package com.pragma.powerup.traceabilitmicroservice.configuration.security.exception;

public class NonUniqueRequestParamException extends RuntimeException{
    public NonUniqueRequestParamException(String message) {
        super(message);
    }
}
