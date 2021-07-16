package com.fabriciomoreira.pricing.service;

import com.fabriciomoreira.pricing.controller.dto.PricingRequestDto;
import com.fabriciomoreira.pricing.controller.dto.PricingResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Random;

@Service
public class PricingService {
    public static final int MAXIMUM_DISCOUNT = 25; // (The maximum discount is 24%, but adding 25 cause the limit value is exclusive to random )
    public static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    Random random;

    public PricingResponseDto discountCalculate(PricingRequestDto priceRequestDto) {
        if (random == null) random = new Random();
        int hourOperation = priceRequestDto.getDateTime().getHour();
        BigDecimal discount = randomDiscount(random, hourOperation);

        BigDecimal priceWithDiscount = priceRequestDto.getPrice().subtract(
                priceRequestDto.getPrice().multiply(discount.divide(ONE_HUNDRED)));
        String description = MessageFormat.format("Purchase time: {0}, Discount: {1}%", Integer.toString(hourOperation), discount.toString());

        return PricingResponseDto.builder()
                .price(priceRequestDto.getPrice())
                .dateTime(priceRequestDto.getDateTime())
                .priceWithDiscount(priceWithDiscount)
                .description(description)
                .build();
    }

    public BigDecimal randomDiscount(Random random, int hour) {
        int value = random.nextInt(MAXIMUM_DISCOUNT - hour);
        return BigDecimal.valueOf(value);
    }
}
