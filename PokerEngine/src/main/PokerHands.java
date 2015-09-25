package main;

import java.util.ArrayList;
import java.util.Collections;

public abstract class PokerHands {

	public static Boolean straightOrFlush(Hand hand) {
		Object one = 1;
		Boolean straight = false;
		Boolean flush = true;
		for (int i = 1; i < 5; i++) {
			if (hand.getCardSuits().get(0) != hand.getCardSuits().get(i)) {
				flush = false;
			}
		}
		if (Collections.frequency(hand.getCardRanks(), 1) <= 1) {
			ArrayList<Integer> helperArray = new ArrayList<Integer>();
			hand.getCardRanks().remove(one);
			for (int i = 0; i < hand.getCardRanks().size(); i++) {
				helperArray.add(hand.getCardRanks().get(i) - i);
			}
			if (Collections.frequency(helperArray, hand.getCardRanks().get(0)) == hand.getCardRanks().size()) {
				straight = true;
			}
		}
		if (straight && flush) {
			if (hand.getCardRanks().get(0) == 10) {
				hand.setTypeOfHand("Royal Flush");
				return true;
			} else {
				hand.setTypeOfHand("Straight Flush");
				return true;
			}
		} else if (flush) {
			hand.setTypeOfHand("Flush");
			return true;
		} else if (straight) {
			hand.setTypeOfHand("Straight");
			return true;
		} else {
			return false;
		}
	}

	//
	public static Boolean row(Hand hand) {
		for (int i = 0; i < 5; i++) {
			if (Collections.frequency(hand.getCardRanks(), hand.getCardRanks().get(i)) == 4) {
				hand.setTypeOfHand("Four of a Kind");
				return true;
			} else if (Collections.frequency(hand.getCardRanks(), hand.getCardRanks().get(i)) == 3) {
				hand.setTypeOfHand("Three of a Kind");
				return true;
			}
		} 
		return false;
	} 

	//
	public static Boolean pair(Hand hand) {
		int x = 0;
		for (int i = 0; i < 5; i++) {
			if (Collections.frequency(hand.getCardRanks(), hand.getCardRanks().get(i)) == 2) {
				x++;
			}
		}
		if (x == 2) {
			hand.setTypeOfHand("One Pair");
			return true;
		} else if (x == 4) {
			hand.setTypeOfHand("Two Pair");
			return true;
		}
		return false;
	}

	//
	public static Boolean fullHouse(Hand hand) {
		if (row(hand) && pair(hand)) {
			hand.setTypeOfHand("Full House");
			return true;
		}
		return false;
	}
}
