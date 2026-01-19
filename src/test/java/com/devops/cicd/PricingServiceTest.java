package com.devops.cicd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingServiceTest {

    private final PricingConfig fakeConfig = new PricingConfig(20.0, 50.0);
    private final PricingService service = new PricingService(fakeConfig);

    @Test
    void applyVat() {
        assertEquals(120.0, service.applyVat(100));
    }

    @Test
    void applyVipDiscount() {
        assertEquals(90, service.applyVipDiscount(100, true));
    }

    @Test
    void shippingCost() {
        assertEquals(0, service.shippingCost(100));
    }

    @Test
    void finalTotal() {
        assertEquals(108, service.finalTotal(100, true));
    }
}