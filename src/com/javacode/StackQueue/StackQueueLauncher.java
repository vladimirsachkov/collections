package com.javacode.StackQueue;

import java.util.Stack;

public class StackQueueLauncher {

    public static void main(String[] args) {
        passengerProcessing();
    }

    private static void passengerProcessing() {
        Stack<Passenger> bus = new Stack<>();
        Passenger passenger = new Passenger("Katerina","Ivanova");
        bus.push(new Passenger("Alex","Vasko"));
        bus.push(new Passenger("Victor","Mikhailov"));
        bus.push(new Passenger("Dmitrii","Petrov"));
        bus.push(passenger);
        bus.push(new Passenger("Ivan","Ivanov"));

        System.out.println("Passenger found at position " + bus.search(passenger));
        System.out.println("Last entered passenger is: "+bus.peek());

        while (!bus.empty()) {
            System.out.println("Passenger :" + bus.pop());
        }
    }

    private static class Passenger {
        private static int number = 1;
        private String name;
        private String surname;

        public Passenger(String name, String surname) {
            number++;
            this.name = name;
            this.surname = surname;
        }

        public static int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Passenger " + name + " " + surname;
        }
    }
}
