package com.javacode.set;

import java.util.*;

public class SetRunner {

    public static void main(String[] args) {

        Set<Car> sixCars = new HashSet<>();
        sixCars.add(new Car("VW", "Golf", 35));
        sixCars.add(new Car("Audi", "A3", 60));
        sixCars.add(new Car("VW", "Polo", 25));
        sixCars.add(new Car("BMW", "Z4", 120));
        sixCars.add(new Car("BMW", "440i", 200));


        Set<Car> europaCars = new HashSet<>();
        europaCars.add(new Car("Toyota", "Auris", 40));
        europaCars.add(new Car("Reno", "Clio", 30));
        europaCars.add(new Car("Reno", "Megan", 50));
        europaCars.add(new Car("VW", "Golf", 45));
        europaCars.add(new Car("VW", "Polo", 35));

        Set<Car> uniqueCars = new HashSet<>(sixCars);
        uniqueCars.addAll(europaCars);
        print(uniqueCars);
//
        sixCars.retainAll(europaCars);
        uniqueCars.retainAll(sixCars);
        print(uniqueCars);

    }

    private static void  print(Set<Car> cars) {
        System.out.printf("%-20s %-20s %-20s \n", "Cars brand", "Model", "Price per day");
        for (Car car: cars) {
            System.out.printf("%-20s %-20s %-20s \n", car.getCarBrand(), car.getModel(), car.getPricePerDay());
        }
    }
}
