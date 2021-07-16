package com.fabriciomoreira.pricing.service;

import com.fabriciomoreira.pricing.controller.dto.PricingRequestDto;
import com.fabriciomoreira.pricing.controller.dto.PricingResponseDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@RunWith(SpringRunner.class)
public class PricingServiceTest {

    public static final int HOUR_TEN = 10;
    public static final int DISCOUNT_FIVE = 5;
    public static final int HOUR_23 = 23;
    public static final int MINUTE = 0;
    private static final int DISCOUNT_TEN = 10;
    private static final BigDecimal PRICE_NINE = BigDecimal.valueOf(9.0);
    final int ZERO = 0;

    private final LocalDateTime TODAY = LocalDateTime.now();

    @InjectMocks
    PricingService priceService;

    @Mock
    Random random;

    @Test
    public void shouldBeFivePercentOfDiscount() {
        Mockito.when(random.nextInt(PricingService.MAXIMUM_DISCOUNT - HOUR_TEN)).thenReturn(DISCOUNT_FIVE);

        BigDecimal discount = priceService.randomDiscount(random, HOUR_TEN);
        Assertions.assertEquals(BigDecimal.valueOf(DISCOUNT_FIVE), discount);
    }

    @Test
    public void shouldHaveNoDiscount() {
        Mockito.when(random.nextInt(PricingService.MAXIMUM_DISCOUNT - HOUR_23)).thenReturn(ZERO);

        LocalDateTime TODAY_AT23_00 = TODAY.withHour(HOUR_23).withMinute(MINUTE);
        PricingRequestDto priceRequestDTO = PricingRequestDto.builder()
                .price(BigDecimal.TEN)
                .dateTime(TODAY_AT23_00)
                .build();

        PricingResponseDto priceResponseDtoNew = priceService.discountCalculate(priceRequestDTO);
        Assertions.assertEquals(BigDecimal.TEN, priceResponseDtoNew.getPriceWithDiscount());
    }

    @Test
    public void shouldPriceBeTenPercent() {
        Mockito.when(random.nextInt(PricingService.MAXIMUM_DISCOUNT - HOUR_TEN)).thenReturn(DISCOUNT_TEN);

        LocalDateTime TODAY_AT10_00 = TODAY.withHour(HOUR_TEN).withMinute(MINUTE);
        PricingRequestDto priceRequestDTO = PricingRequestDto.builder()
                .price(BigDecimal.TEN)
                .dateTime(TODAY_AT10_00)
                .build();

        PricingResponseDto priceResponseDtoNew = priceService.discountCalculate(priceRequestDTO);
        Assertions.assertEquals(PRICE_NINE, priceResponseDtoNew.getPriceWithDiscount());
    }
}
