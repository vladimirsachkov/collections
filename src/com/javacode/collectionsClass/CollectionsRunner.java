package com.javacode.collectionsClass;

import java.util.*;

public class CollectionsRunner {

    public static void main(String[] args) {
        List<Card> deckOfCards = new ArrayList<>();
        for (Card.Face face: Card.Face.values()) {
            for (Card.Suit suit: Card.Suit.values()) {
                deckOfCards.add(new Card(suit, face));
            }
        }

        Collections.shuffle(deckOfCards);
        Collections.sort(deckOfCards);
        Card card = new Card(Card.Suit.SPADES, Card.Face.Queen);

        int i = Collections.binarySearch(deckOfCards, card);
        if(i>=0) {
            System.out.println("Card was found at position " + i);
        } else {
            System.out.println("Card was not found");
        }


        List<Card> cardList = new ArrayList<>(deckOfCards);
        Collections.fill(cardList,card);
        Collections.addAll(cardList, card, card, card);
        Collections.copy(cardList, deckOfCards);
        int frequency = Collections.frequency(cardList, card);
        System.out.println("Frequency of " + card + "is" + frequency);

        System.out.println("MIN :"+Collections.min(cardList));
        System.out.println("MAX :"+Collections.max(cardList));
//       printOutput(cardList);

//      System.out.println("\n\nCards after shuffle");
//       printOutput(deckOfCards);

//       System.out.println("Card after sorting");
 //       printOutput(deckOfCards);
    }

    private static void printOutput(List<Card> deckOfCards) {
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " ");
        }
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return suit == card.suit && face == card.face;
        }

        @Override
        public int hashCode() {
            return Objects.hash(suit, face);
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
                return String.valueOf(card1.getSuit()).compareTo(String.valueOf(card2.getSuit()));
            }
            return 0;
        }
    }
}
