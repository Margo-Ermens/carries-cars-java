package com.carriesCars.pricingEngine;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PricingEngineTest {

    @Test
    public void CalculatePrice_charged_per_minute() {
        PricingEngine pricingEngine = new PricingEngine();

        Duration duration = Duration.ofMinutes(1);
        Money pricePerMinute = Money.of(CurrencyUnit.EUR, 0.24);
        Money actual = pricingEngine.calculatePrice(duration, pricePerMinute);

        Money expected = pricePerMinute;
        assertEquals(expected, actual);
    }

    @Test
    public void CalculatePrice_charged_per_minute_V2() {
        PricingEngine pricingEngine = new PricingEngine();

        Duration duration = Duration.ofMinutes(1);
        PricePerMinute pricePerMinute = new PricePerMinute(Money.of(CurrencyUnit.EUR, 0.24));
        Money actual = pricingEngine.calculatePriceV2(duration, pricePerMinute);

        Money expected = Money.of(CurrencyUnit.EUR, 0.24);
        assertEquals(expected, actual);
    }

}