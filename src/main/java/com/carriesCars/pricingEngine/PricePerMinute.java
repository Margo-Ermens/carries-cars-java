package com.carriesCars.pricingEngine;

import org.joda.money.Money;

class PricePerMinute {
    private Money pricePerMinute;

    public PricePerMinute(Money pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public Money calculateMinutePrice(Duration someDuration) {
        return pricePerMinute.multipliedBy(someDuration.durationInMinutes());
    }
}
