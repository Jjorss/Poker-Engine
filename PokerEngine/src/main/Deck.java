package main;

// Import ArrayList to store cards
import java.util.ArrayList;
// Import Collections to shuffle array list
import java.util.Collections;

import pokerEnums.eSuits;

public class Deck{
	
	// This is the array that holds the cards to be drawn
	private ArrayList<Card> cards;
	// This is the array that holds the already drawn cards
	private ArrayList<Card> drawnCards = new ArrayList<Card>();
	
	// The constructor initializes an empty array of cards, then populates that array with a set of 52 cards
	// after which it shuffles them
	public Deck(Boolean wildCards){
		cards = new ArrayList<Card>();
		for (int i = 1; i < 14; i++){
			cards.add(new Card(i, eSuits.HEARTS));
		}
		for (int i = 1; i < 14; i++){
			cards.add(new Card(i, eSuits.DIAMONDS));
		}
		for (int i = 1; i < 14; i++){
			cards.add(new Card(i, eSuits.SPADES));
		}
		for (int i = 1; i < 14; i++){
			cards.add(new Card(i, eSuits.CLUBS));
		}
		Collections.shuffle(cards);
		if(wildCards){
			
		}
	}
	
	// Draws the first card from the deck, while also removing that card and adding it to the array of drawnCards
	public Card draw(){
		Card myCard = getDeck().get(0);
		drawnCards.add(myCard);
		getDeck().remove(0);
		return myCard;
	}
	
	// Method that returns the amount of cards left to be drawn in a deck
	public int count(){
		return getDeck().size();
	}
	
	// A main method to test out all the methods
	public static void main(String[] args){
		Deck deck1 = new Deck(false);
		Card.printCards(deck1.getDeck());
		System.out.println("Cards remaining: " + deck1.count());
		System.out.println("#####");
		Card drawnCard = deck1.draw();
		System.out.println("Drawn card");
		System.out.println(drawnCard.getRank());
		System.out.println(drawnCard.getSuit());
		System.out.println("------");
		System.out.println("Cards remaining: " + deck1.count());
		System.out.println("#####");
		System.out.println("Cards left in deck:");
		System.out.println("------");
		Card.printCards(deck1.getDeck());
	}
	
	// A getter for the deck of cards, returns the array
	public ArrayList<Card> getDeck() {
		return cards;
	}
	
	// A getter for the drawn cards, returns the array
	public ArrayList<Card> getDrawnCards() {
		return drawnCards;
	}
}
