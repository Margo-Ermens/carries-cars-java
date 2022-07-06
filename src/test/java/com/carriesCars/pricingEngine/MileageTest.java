package com.carriesCars.pricingEngine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MileageTest {

    @Test
    public void One_Mileage_is_identical_to_another_Mileage_if_they_have_an_identical_value() {
        Mileage someMileage = new Mileage(250);
        Mileage anotherIdenticalMileage = new Mileage(250);

        // Do you agree that this test should pass?
        assertEquals(someMileage, anotherIdenticalMileage);
    }

    private class Mileage {
        public Mileage(int mileage) {
        }
    }
}
