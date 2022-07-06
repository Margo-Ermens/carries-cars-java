package com.carriesCars.pricingEngine;

import org.joda.money.Money;

public class PricingEngine {
    public Money calculatePrice(Duration duration, Money pricePerMinute) {
        return calculatePriceV2(duration, new PricePerMinute(pricePerMinute));
    }

    public Money calculatePriceV2(Duration duration, PricePerMinute pricePerMinute) {
        return pricePerMinute.calculateMinutePrice(duration);
    }
}
