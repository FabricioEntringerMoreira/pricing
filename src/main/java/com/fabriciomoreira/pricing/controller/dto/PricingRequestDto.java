package com.fabriciomoreira.pricing.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PricingRequestDto {
    @NotNull(message = "Price must be informed.")
    private BigDecimal price;
    @NotNull(message = "Date and time must be informed.")
    private LocalDateTime dateTime;
}
