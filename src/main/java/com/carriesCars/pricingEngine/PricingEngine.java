package com.carriesCars.pricingEngine;

import org.joda.money.Money;

public class PricingEngine {
    public Money calculatePrice(Duration duration, Money pricePerMinute) {
        return pricePerMinute.multipliedBy(duration.durationInMinutes());
    }
    public Money calculatePrice(Duration duration, Money pricePerMinute, Rental rental) {
        Money totalPrice = pricePerMinute.multipliedBy(duration.durationInMinutes());
        if(rental.getReservationDuration().durationInMinutes() - rental.getBaseMinutesToReach().durationInMinutes() > 0) {
            Duration paidExtensionTime = Duration.ofMinutes(rental.getReservationDuration().durationInMinutes() - rental.getBaseMinutesToReach().durationInMinutes());
            totalPrice = totalPrice.plus(rental.getExtensionCostPerMinute().multipliedBy(paidExtensionTime.durationInMinutes()));
        }
        return totalPrice;
    }

    public Money calculatePrice(Rental rental) {
        Money totalPrice = rental.getPricePerMinute().multipliedBy(rental.getRentalDuration().durationInMinutes());
        if(rental.getReservationDuration().durationInMinutes() - rental.getBaseMinutesToReach().durationInMinutes() > 0) {
            Duration paidExtensionTime = Duration.ofMinutes(rental.getReservationDuration().durationInMinutes() - rental.getBaseMinutesToReach().durationInMinutes());
            totalPrice = totalPrice.plus(rental.getExtensionCostPerMinute().multipliedBy(paidExtensionTime.durationInMinutes()));
        }
        int extraKilometers = rental.getKilometersDriven() - rental.getBaseKilometers();
        if(extraKilometers > 0) {
            totalPrice = totalPrice.plus(rental.getExtendedKilometerPrice().multipliedBy(extraKilometers));
        }
        return totalPrice;
    }
}
