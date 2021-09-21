package com.javacode.set;

import java.util.Objects;

public class Car {
    private final String carBrand;
    private final String model;
    private final Integer pricePerDay;

    public Car(String carBrand, String model, int pricePerDay) {
        this.carBrand = carBrand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Car car = (Car) obj;
        if (!this.carBrand.equals(car.getCarBrand())) {
            return false;
        }
        if (!this.model.equals(car.getModel())) {
            return false;
        }
        return !this.pricePerDay.equals(car.getPricePerDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(carBrand, model, pricePerDay);
    }
}
