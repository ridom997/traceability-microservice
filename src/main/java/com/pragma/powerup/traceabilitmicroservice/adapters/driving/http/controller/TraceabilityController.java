package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.controller;

import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.request.OrderLogDto;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.response.TraceabilityResponseDto;
import com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.handlers.ITraceabilityHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "Get list of logs of an order",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of logs of order founded (return a list of the example object)",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TraceabilityResponseDto.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized request",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "404", description = "No logs founded",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @SecurityRequirement(name = "jwt")
    @GetMapping("/order/{idOrder}")
    public ResponseEntity<List<TraceabilityResponseDto>> getTraceabilityListOfOrder(@PathVariable("idOrder") @Valid @NotNull Long idOrder){
        return ResponseEntity.status(HttpStatus.OK)
                .body(traceabilityHandler.getTraceabilityListOfOrder(idOrder));
    }
}
