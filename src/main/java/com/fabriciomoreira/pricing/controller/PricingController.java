package com.fabriciomoreira.pricing.controller;

import com.fabriciomoreira.pricing.controller.dto.PricingRequestDto;
import com.fabriciomoreira.pricing.controller.dto.PricingResponseDto;
import com.fabriciomoreira.pricing.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("prices")
public class PricingController {

    @Autowired
    PricingService priceService;

    @PostMapping()
    @CrossOrigin(origins = "*")
    public ResponseEntity<PricingResponseDto> pricingCalculate(@RequestBody @Valid PricingRequestDto priceRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                priceService.discountCalculate(priceRequestDto)
        );
    }
}
