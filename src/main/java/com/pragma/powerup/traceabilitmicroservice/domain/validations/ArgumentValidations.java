package com.pragma.powerup.traceabilitmicroservice.domain.validations;

import com.pragma.powerup.traceabilitmicroservice.domain.exceptions.FailValidatingRequiredVariableException;

import static com.pragma.powerup.traceabilitmicroservice.configuration.Constants.NOT_PRESENT_MESSAGE;

public class ArgumentValidations {

    private ArgumentValidations() {
    }

    public static void validateString(String str, String nameVariable){
        if(str == null)
            throw new FailValidatingRequiredVariableException(nameVariable + NOT_PRESENT_MESSAGE);
    }

    public static void validateObject(Object obj, String nameObject){
        if(obj == null)
            throw new FailValidatingRequiredVariableException(nameObject + NOT_PRESENT_MESSAGE);
    }
}
