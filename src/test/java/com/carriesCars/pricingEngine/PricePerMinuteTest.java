package com.carriesCars.pricingEngine;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricePerMinuteTest {

    @Test
    public void Multiplies_with_Duration() {
        PricePerMinute pricePerMinute = new PricePerMinute(Money.of(CurrencyUnit.EUR, 0.24));
        Duration someDuration = new Duration(8);

        Money actual = pricePerMinute.calculateMinutePrice(someDuration);
        Money expected = Money.of(CurrencyUnit.EUR, 1.92);
        assertEquals(expected, actual);
    }

    private class PricePerMinute {
        private Money pricePerMinute;

        public PricePerMinute(Money pricePerMinute) {
            this.pricePerMinute = pricePerMinute;
        }

        public Money calculateMinutePrice(Duration someDuration) {
            return pricePerMinute.multipliedBy(someDuration.durationInMinutes());
        }
    }
}