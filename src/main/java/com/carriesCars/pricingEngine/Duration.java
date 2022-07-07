package com.carriesCars.pricingEngine;

import java.util.Objects;

public class Duration {
    private final int durationInMinutes;

    public Duration(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public static Duration ofMinutes(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Sorry, Duration should be at least one minute.");
        }

        return new Duration(length);
    }

    public static Duration fromString(String textRepresentation) {
        return Duration.ofMinutes(Integer.parseInt(textRepresentation));
    }

    @Override
    public String toString() {
        return String.format("%d", this.durationInMinutes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return durationInMinutes == duration.durationInMinutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationInMinutes);
    }

    public int durationInMinutes() {
        return this.durationInMinutes;
    }
}
