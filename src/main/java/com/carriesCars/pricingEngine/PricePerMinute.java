package com.carriesCars.pricingEngine;

import org.jetbrains.annotations.NotNull;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

final class PricePerMinute {
    public Money calculateMinutePrice(@NotNull Duration someDuration) {
        return pricePerMinute.multipliedBy(someDuration.durationInMinutes());
    }

    public static PricePerMinute inAmsterdam() {
        return new PricePerMinute(Money.of(CurrencyUnit.EUR, 0.24));
    }

    // Boring code below

    private Money pricePerMinute;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PricePerMinute that = (PricePerMinute) o;

        return pricePerMinute.equals(that.pricePerMinute);
    }

    @Override
    public int hashCode() {
        return pricePerMinute.hashCode();
    }

    public PricePerMinute(@NotNull Money pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }
}
