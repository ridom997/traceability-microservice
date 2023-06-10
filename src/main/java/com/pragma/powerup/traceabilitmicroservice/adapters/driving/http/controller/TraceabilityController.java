package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.controller;

import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.request.OrderLogDto;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.handlers.ITraceabilityHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/log")
@RequiredArgsConstructor
public class TraceabilityController {

    private final ITraceabilityHandler traceabilityHandler;

    @Operation(summary = "Create a log when the status change in an order",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Log created",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "401", description = "Unauthorized request",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @SecurityRequirement(name = "jwt")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //to response if everything is ok
    public void saveLogOrder(@Valid @RequestBody OrderLogDto orderLogDto){
        traceabilityHandler.saveLog(orderLogDto);
    }
}
