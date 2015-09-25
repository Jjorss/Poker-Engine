package main;

//Import ArrayList to store cards
import java.util.ArrayList;

import pokerEnums.eSuits;

public class Card {
	
	// The number on the card
	private int rank;
	// The suit of the card
	private eSuits suit;
	
	// A constructor for a card that takes in the card's number and suit
	public Card(int rank, eSuits suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	// A getter that returns the cards number
	public int getRank() {
		return rank;
	}
	
	// A getter that returns the cards suit
	public eSuits getSuit() {
		return suit;
	}

	public void setSuit(eSuits suit) {
		this.suit = suit;
	}
	
	// Static method that prints out all the cards in a deck or hand
	public static void printCards(ArrayList<Card> cards){
		for (int i = 0; i < cards.size()-1; i++){
			int number = cards.get(i).getRank();
			eSuits suit = cards.get(i).getSuit();
			if (number == 1){
				System.out.println("Ace");
				System.out.println(suit);
			} else if (number == 11){
				System.out.println("Jack");
				System.out.println(suit);
			} else if (number == 12){
				System.out.println("Queen");
				System.out.println(suit);
			} else if (number == 13){
				System.out.println("King");
				System.out.println(suit);
			} else {
				System.out.println(number);
				System.out.println(suit);
			}
			System.out.println("------");
		}
	}

	
}
