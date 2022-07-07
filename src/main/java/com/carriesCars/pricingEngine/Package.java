package com.carriesCars.pricingEngine;

import lombok.Data;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

@Data
public class Package {

    private Duration includedDrivingTime;
    private int includedMileage;
    private Money basePrice;

    public Package(Duration ofMinutes, int i, Money of) {
    }

    public static Package defaultPackage() {
        return new Package(Duration.ofMinutes(0), 250, Money.of(CurrencyUnit.EUR, 0));
    }

}
