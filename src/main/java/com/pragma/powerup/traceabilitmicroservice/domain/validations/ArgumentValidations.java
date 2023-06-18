package com.pragma.powerup.traceabilitmicroservice.domain.validations;

import com.pragma.powerup.traceabilitmicroservice.domain.exceptions.FailValidatingRequiredVariableException;

public class ArgumentValidations {

    private static final String NOT_PRESENT_MESSAGE = " is not present";
    private ArgumentValidations() {
    }

    public static void validateString(String str, String nameVariable){
        if(str == null || str.isEmpty())
            throw new FailValidatingRequiredVariableException(nameVariable + NOT_PRESENT_MESSAGE);
    }

    public static void validateObject(Object obj, String nameObject){
        if(obj == null)
            throw new FailValidatingRequiredVariableException(nameObject + NOT_PRESENT_MESSAGE);
    }
}
