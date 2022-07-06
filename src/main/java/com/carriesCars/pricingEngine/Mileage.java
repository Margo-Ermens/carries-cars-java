package com.carriesCars.pricingEngine;

class Mileage {
    private int mileage;

    public Mileage(int mileage) {
        this.mileage = mileage;
    }

    public Mileage increaseWith(int increaseWith)
    {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mileage mileage1 = (Mileage) o;

        return mileage == mileage1.mileage;
    }

    @Override
    public int hashCode() {
        return mileage;
    }
}
