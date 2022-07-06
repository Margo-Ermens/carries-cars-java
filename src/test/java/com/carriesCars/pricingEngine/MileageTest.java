package com.carriesCars.pricingEngine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MileageTest {

    @ParameterizedTest(name = "mileage=''{0}'' (example no. {index})")
    @ValueSource(
        ints = {
            250,
            1
        }
    )
    public void One_Mileage_is_identical_to_another_Mileage_if_they_have_an_identical_value(int aMileage) {
        Mileage someMileage = new Mileage(aMileage);
        Mileage anotherIdenticalMileage = new Mileage(aMileage);

        // Do you agree that this test should pass?
        assertEquals(someMileage, anotherIdenticalMileage);
    }
}
