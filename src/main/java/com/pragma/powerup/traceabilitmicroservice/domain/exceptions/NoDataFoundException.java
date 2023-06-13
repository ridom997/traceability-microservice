package com.pragma.powerup.traceabilitmicroservice.domain.exceptions;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String message) {
        super(message);
    }
}
