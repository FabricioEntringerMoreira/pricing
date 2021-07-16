package com.fabriciomoreira.pricing.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PricingResponseDto {
    private BigDecimal price;
    private BigDecimal priceWithDiscount;
    private String description;
    private LocalDateTime dateTime;
}
