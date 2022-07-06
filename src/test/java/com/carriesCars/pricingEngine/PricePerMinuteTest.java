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

    @Test
    public void In_Amsterdam_is_24_eurocent() {
        PricePerMinute actual = PricePerMinute.inAmsterdam();
        PricePerMinute expected = new PricePerMinute(Money.of(CurrencyUnit.EUR, 0.24));

        assertEquals(expected, actual);
    }
}