package com.devops.cicd;

public final class PricingService {

    private final PricingConfig config;

    public PricingService(PricingConfig config) {
        this.config = config;
    }

    public double applyVat(double amountExclVat) {
        return amountExclVat * ((100 + config.getVatRate()) / 100);
    }

    public double applyVipDiscount(double amount, boolean vip) {
        return amount * 0.9;
    }

    public double shippingCost(double amount) {
        return (amount >= config.getFreeShippingThreshold()) ? 0 : 4.99;
    }

    /**
     * - TVA appliquée d'abord : HT -> TTC
     * - remise VIP appliquée sur TTC
     * - frais de livraison ajoutés ensuite (calculés sur TTC)
     */
    public double finalTotal(double amountExclVat, boolean vip) {
        double total = applyVipDiscount(applyVat(amountExclVat), vip);
        return total + shippingCost(total);
    }
}