package com.pragma.powerup.traceabilitmicroservice.configuration;

import com.pragma.powerup.traceabilitmicroservice.configuration.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {


    private final JwtProvider jwtProvider;

}
