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
        Money pricePerMinute = Money.of(CurrencyUnit.EUR, 0.30);
        Money actual = pricingEngine.calculatePrice(duration, pricePerMinute);

        Money expected = pricePerMinute;
        assertEquals(expected, actual);
    }

    @Test
    public void CalculatePrice_extended_reservation() {
        Duration baseMinutesToReach = Duration.ofMinutes(20);
        Duration reservationDuration = Duration.ofMinutes(50);
        Duration drivingTime = Duration.ofMinutes(10);
        Money drivingPricePerMinute = Money.of(CurrencyUnit.EUR, 0.24);
        Money extensionPricePerMinute = Money.of(CurrencyUnit.EUR, 0.09);

        PricingEngine pricingEngine = new PricingEngine();
        Rental rental = new Rental();
        rental.setReservationDuration(reservationDuration);
        rental.setBaseMinutesToReach(baseMinutesToReach);
        rental.setExtensionCostPerMinute(extensionPricePerMinute);

        long extensionTime = reservationDuration.durationInMinutes() - baseMinutesToReach.durationInMinutes();
        extensionTime = extensionTime >= 0 ? extensionTime : 0;
        Money expected = extensionPricePerMinute.multipliedBy(extensionTime).plus(drivingPricePerMinute.multipliedBy(drivingTime.durationInMinutes()));
        Money actual = pricingEngine.calculatePrice(drivingTime, drivingPricePerMinute, rental);
        assertEquals(expected, actual);
    }

    @Test
    public void CalculatePrice_without_extension() {
        Duration baseMinutesToReach = Duration.ofMinutes(20);
        Duration reservationDuration = Duration.ofMinutes(10);
        Duration drivingTime = Duration.ofMinutes(25);
        Money drivingPricePerMinute = Money.of(CurrencyUnit.EUR, 0.24);
        Money extensionPricePerMinute = Money.of(CurrencyUnit.EUR, 0.09);

        PricingEngine pricingEngine = new PricingEngine();
        Rental rental = new Rental();
        rental.setReservationDuration(reservationDuration);
        rental.setBaseMinutesToReach(baseMinutesToReach);
        rental.setExtensionCostPerMinute(extensionPricePerMinute);

        long extensionTime = reservationDuration.durationInMinutes() - baseMinutesToReach.durationInMinutes();
        extensionTime = extensionTime >= 0 ? extensionTime : 0;
        Money expected = extensionPricePerMinute.multipliedBy(extensionTime).plus(drivingPricePerMinute.multipliedBy(drivingTime.durationInMinutes()));
        Money actual = pricingEngine.calculatePrice(drivingTime, drivingPricePerMinute, rental);
        assertEquals(expected, actual);
    }

    @Test
    public void CalculatePrice_kilometer_extension() {
        Duration baseMinutesToReach = Duration.ofMinutes(20);
        Duration reservationDuration = Duration.ofMinutes(47);
        Duration rentalTime = Duration.ofMinutes(135);
        Money drivingPricePerMinute = Money.of(CurrencyUnit.EUR, 0.24);
        Money extensionPricePerMinute = Money.of(CurrencyUnit.EUR, 0.09);
        Money extendedKilometerPrice = Money.of(CurrencyUnit.EUR, 0.19);
        int baseKilometers = 250;
        int kilometersDriven = 287;

        PricingEngine pricingEngine = new PricingEngine();
        Rental rental = new Rental();
        rental.setRentalDuration(rentalTime);
        rental.setReservationDuration(reservationDuration);
        rental.setBaseMinutesToReach(baseMinutesToReach);
        rental.setExtensionCostPerMinute(extensionPricePerMinute);
        rental.setPricePerMinute(drivingPricePerMinute);
        rental.setExtendedKilometerPrice(extendedKilometerPrice);
        rental.setBaseKilometers(baseKilometers);
        rental.setKilometersDriven(kilometersDriven);

        Money expected = Money.of(CurrencyUnit.EUR, 0);
        expected = expected.plus(drivingPricePerMinute.multipliedBy(rentalTime.durationInMinutes()));
        expected = expected.plus(extendedKilometerPrice.multipliedBy(kilometersDriven - baseKilometers));
        expected = expected.plus(extensionPricePerMinute.multipliedBy(reservationDuration.durationInMinutes() - baseMinutesToReach.durationInMinutes()));

        Money actual = pricingEngine.calculatePrice(rental);
        assertEquals(expected, actual);
    }

    @Test
    public void CalculatePrice_default_package() {
        Package defaultPackage = Package.defaultPackage();
        Rental rental = new Rental();
        rental.setAPackage(defaultPackage);
        rental.setRentalDuration(Duration.ofMinutes(123));
        rental.setKilometersDriven(189);
    }

    @Test
    public void CalculatePrice_driving_price() {
        Duration drivingDuration = Duration.ofMinutes(123);
        PricingEngine.calculate
    }

}