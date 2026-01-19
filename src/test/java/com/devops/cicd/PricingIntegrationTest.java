package com.devops.cicd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingIntegrationTest {

    @Test
    void fullPricingFlow_withRealConfigFile() {
        PricingConfigLoader loader = new PricingConfigLoader();
        PricingConfig config = loader.load();
        PricingService service = new PricingService(config);

        assertEquals(108, service.finalTotal(100, true));
    }

}
