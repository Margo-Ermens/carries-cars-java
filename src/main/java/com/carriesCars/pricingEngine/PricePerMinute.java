package com.carriesCars.pricingEngine;

import org.joda.money.Money;

final class PricePerMinute {
    public Money calculateMinutePrice(Duration someDuration) {
        return pricePerMinute.multipliedBy(someDuration.durationInMinutes());
    }

    public static PricePerMinute inAmsterdam() {
        return null;
    }

    // Boring code below

    private Money pricePerMinute;

    public PricePerMinute(Money pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }
}
