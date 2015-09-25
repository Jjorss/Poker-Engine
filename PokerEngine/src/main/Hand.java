package main;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eSuits;

public class Hand extends PokerHands{
	
	// The type of the hand, whether it is a flush, straight, one pair...
	private String typeOfHand = "High Card";
	// The array that contains the cards that one has in their hand
	private ArrayList<Card> cardsInHand = new ArrayList<Card>();
	// The array that contains just the number of each card in the hand
	private ArrayList<Integer> cardRanks = new ArrayList<Integer>();
	// The array that contains just the suit of each card in the hand
	private ArrayList<eSuits> cardSuits = new ArrayList<eSuits>();
	// The array that contains the left over kickers in the hand.
	private ArrayList<Integer> kicker = new ArrayList<Integer>();
	private int highHand = 0;
	private int lowHand = 0;
	
	// A constructor that draws five cards out of the deck which was 
	// passed as the constructor's argument
	public Hand(Deck deck){
		for(int i = 0; i < 5; i++) {
			cardsInHand.add(deck.draw());
		}
		for (int i = 0; i < 5; i++) {
			cardRanks.add(cardsInHand.get(i).getRank());
			cardSuits.add(cardsInHand.get(i).getSuit());
		}
		Collections.sort(cardRanks);
	}
	
	// A method that takes in a Hand
	// return an integer
	// This method judges a hand and return an integer based on how good the hand
	// is, the higher the integer the better the hand. Range: 1-10
	public String judge(Hand hand) {
		if(PokerHands.straightOrFlush(hand)) {
			return getTypeOfHand();
		} else if(PokerHands.fullHouse(hand)) {
			return getTypeOfHand();
		} else if(PokerHands.row(hand)) {
			return getTypeOfHand();
		} else if(PokerHands.pair(hand)) {
			return getTypeOfHand();
		} else {
			return getTypeOfHand();
		}
		
	}
	
	public ArrayList<Card> getcardsInHand() {
		return cardsInHand;
	}
	
	public void setCardsInHand(ArrayList<Card> cardsInHand) {
		this.cardsInHand = cardsInHand;
		cardRanks.clear();
		cardSuits.clear();
		for (int i = 0; i < 5; i++) {
			cardRanks.add(cardsInHand.get(i).getRank());
			cardSuits.add(cardsInHand.get(i).getSuit());
		}
		Collections.sort(cardRanks);
	}
	
	public void setTypeOfHand(String handType){
		this.typeOfHand = handType;
	}
	
	public String getTypeOfHand(){
		return typeOfHand;
	}
	
	public ArrayList<Integer> getCardRanks(){
		return cardRanks;
	}
	
	public ArrayList<eSuits> getCardSuits(){
		return cardSuits;
	}

	public ArrayList<Integer> getKicker() {
		return kicker;
	}

	public void setKicker(ArrayList<Integer> kicker) {
		this.kicker = kicker;
	}

	public int getHighHand() {
		return highHand;
	}

	public void setHighHand(int highHand) {
		this.highHand = highHand;
	}

	public int getLowHand() {
		return lowHand;
	}

	public void setLowHand(int lowHand) {
		this.lowHand = lowHand;
	}
}
