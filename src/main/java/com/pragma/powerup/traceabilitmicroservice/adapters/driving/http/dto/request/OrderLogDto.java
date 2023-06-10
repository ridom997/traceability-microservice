package com.pragma.powerup.traceabilitmicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.traceabilitmicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderLogDto {

    @Schema(example = "1")
    @NotNull
    private Long idOrder;

    @Schema(example = "2")
    @NotNull
    private Long idClient;

    @Schema(example = "client@mail.com")
    @Email(regexp = Constants.MAIL_REGEX)
    @NotBlank
    private String mailClient;

    @Schema(example = "1")
    @NotNull
    private Integer previousStatus;

    @Schema(example = "2")
    @NotNull
    private Integer newStatus;

    @Schema(example = "122")
    @NotNull
    private Long idEmployee;

    @Schema(example = "employee@mail.com")
    @Email(regexp = Constants.MAIL_REGEX)
    @NotBlank
    private String mailEmployee;

    @NotNull
    private LocalDateTime date;
}
