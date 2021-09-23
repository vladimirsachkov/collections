package com.javacode.map;

import com.javacode.set.Car;

import java.util.HashMap;
import java.util.Map;

public class MapLauncher {

    public static void main(String[] args) {
        Map<Car, Integer> numbers = new HashMap<>();
        numbers.put(new Car("Toyota", "Corolla", 50), 50);
        numbers.put(new Car("Audi", "A5", 50), 51);
        numbers.put(new Car("Toyota", "Auris", 50), 52);

        System.out.println(numbers.get(new Car("Audi", "A5", 50)));
    }
}
