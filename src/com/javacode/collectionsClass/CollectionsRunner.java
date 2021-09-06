package com.javacode.collectionsClass;

import java.util.*;

public class CollectionsRunner {

    public static void main(String[] args) {
        List<Card> deckOfCards = new ArrayList<>();
        for (Card.Face face: Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                deckOfCards.add(new Card(suit, face));
            }
        }

//        System.out.println("Original deck of cards");
//        for (int i=0; i<deckOfCards.size(); i++) {
//            System.out.printf("%-20s %s", deckOfCards.get(i), (i+1)%4==0 ? "\n":" ");
//        }
        Collections.shuffle(deckOfCards);

        System.out.println("\n\nCards after shuffle");
        for (int i=0; i<deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i+1)%4==0 ? "\n":" ");
        }

        Collections.sort(deckOfCards, new CardComparator());
        System.out.println("Card after sorting");
        for (int i=0; i<deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i+1)%4==0 ? "\n":" ");
        }
//        List<String> colors = new ArrayList<>();
//
//        colors.add("yellow");
//        colors.add("blue");
//        colors.add("green");
//        colors.add("black");
//        colors.add("red");
//
//        System.out.println("List before sorting "+colors);
//        Collections.sort(colors);
//        System.out.println("List after sorting "+colors);
    }

    public static class Card implements  Comparable<Card> {


        private enum Suit {SPADES, HEARTS, CLUBS, DIMONDS};

        private enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King};

        private final Suit suit;

        private final Face face;

        public Card(Suit suit, Face face) {
            this.suit = suit;
            this.face = face;
        }

        public Suit getSuit() {
            return suit;
        }

        public Face getFace() {
            return face;
        }

        @Override
        public int compareTo(Card card) {
            Face[] values = Face.values();
            List<Face> faces = Arrays.asList(values);

            if (faces.indexOf(this.face)<faces.indexOf(card.getFace())) {
                return -1;
            } else if (faces.indexOf(this.face)>faces.indexOf(card.getFace())) {
                return +1;
            } else if (faces.indexOf(this.face)==faces.indexOf(card.getFace())) {
                return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
            }

            return 0;
        }

        @Override
        public String toString() {
            return face +" of " +suit;
        }
    }

    public static  class CardComparator implements Comparator<Card> {
        List<Card.Face> faces = Arrays.asList(Card.Face.values());

        @Override
        public int compare(Card card1, Card card2) {
            if (faces.indexOf(card1.getFace()) < faces.indexOf(card2.getFace())) {
                return 1;
            } else if (faces.indexOf(card1.getFace()) > faces.indexOf(card2.getFace())) {
                return -1;
            } else if (faces.indexOf(card1.getFace()) == faces.indexOf(card2.getFace())) {
                return 0;
            }
            return 0;
        }
    }
}
