package com.carriesCars.pricingEngine;

import lombok.Data;

@Data
public class Rental {
    private Duration reservationDuration;
    private Duration baseMinutesToReach;
    private Duration rentalDuration;

    private int kilometersDriven;
    private Package aPackage;
}
