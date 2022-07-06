package com.carriesCars.pricingEngine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
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

        assertEquals(someMileage, anotherIdenticalMileage);
    }

    @Test
    public void Mileage_can_be_increased() {
        Mileage someMileage = new Mileage(25);
        Mileage increasedMileage = someMileage.increaseWith(10);

        assertAll("Mileage#increaseWith does not modify the original Mileage",
                () -> assertEquals(new Mileage(25), someMileage),
                () -> assertEquals(new Mileage(35), increasedMileage)
        );
    }
}
