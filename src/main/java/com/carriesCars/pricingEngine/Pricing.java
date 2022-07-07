package com.carriesCars.pricingEngine;

import lombok.Data;
import org.joda.money.Money;

@Data
public class Pricing {
    private Money extensionCostPerMinute;
    private Money pricePerMinute;
    private Money extendedKilometerPrice;
}
