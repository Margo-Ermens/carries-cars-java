package com.carriesCars.pricingEngine;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

final class PricePerMinute {
    public Money calculateMinutePrice(Duration someDuration) {
        return pricePerMinute.multipliedBy(someDuration.durationInMinutes());
    }

    public static PricePerMinute inAmsterdam() {
        return new PricePerMinute(Money.of(CurrencyUnit.EUR, 0.24));
    }

    // Boring code below

    private Money pricePerMinute;

    public PricePerMinute(Money pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }
}
