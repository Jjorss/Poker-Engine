package main;

import java.util.ArrayList;

public class Play {
	
	public static void main(String[] args) {
		ArrayList<Hand> hands = new ArrayList<Hand>();
		Deck deck = new Deck(false);
		Hand winner = null;
		ArrayList<Card> winnerCards = new ArrayList<Card>();
		for(int i = 0; i < 2; i ++) {
			hands.add(new Hand(deck));
		}
		System.out.println(hands.size());
		winner = Hand.judge(hands);
		winnerCards = winner.getcardsInHand();
		
		
		System.out.println("Winner is: ");
		Card.printCards(winnerCards);
	}
}
