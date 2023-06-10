package com.pragma.powerup.traceabilitmicroservice.domain.utils;

import com.pragma.powerup.traceabilitmicroservice.domain.exceptions.FailCreatingRandomIdException;

import java.security.SecureRandom;
import java.util.Random;

public class LongUtils {
    private LongUtils(){}

    public static Long makeRandomId(){
        try{
            Random random = SecureRandom.getInstanceStrong();
            return random.nextLong();
        }catch (Exception e){
            throw new FailCreatingRandomIdException();
        }
    }
}
