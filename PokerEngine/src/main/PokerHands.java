package main;

import java.util.ArrayList;
import java.util.Collections;

public abstract class PokerHands {
	
	// sets low hand
	public static Boolean straightOrFlush(Hand hand) {
		Object one = 1;
		Boolean straight = false;
		Boolean flush = true;
		int max = 0;
		for(int a = 0; a < 5; a++) {
			max = Math.max(max, hand.getCardRanks().get(a));
		}
		hand.setHighHand(max);
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
				hand.setLowHand(0);
				return true;
			} else {
				hand.setTypeOfHand("Straight Flush");
				hand.setLowHand(0);
				return true;
			}
		} else if (flush) {
			hand.setTypeOfHand("Flush");
			hand.setLowHand(0);
			return true;
		} else if (straight) {
			hand.setTypeOfHand("Straight");
			hand.setLowHand(0);
			return true;
		} else {
			return false;
		}
	}

	// sets low hand, High hand, kicker TESTED
	public static Boolean row(Hand hand) {
		ArrayList<Integer> kicker = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			if (Collections.frequency(hand.getCardRanks(), hand.getCardRanks().get(i)) == 4) {
				hand.setTypeOfHand("Four of a Kind");
				hand.setHighHand(hand.getCardRanks().get(i));
				hand.setLowHand(0);
				for(int x = 0; x < 5; x++) {
					if(hand.getCardRanks().get(x) != hand.getHighHand()) {
						kicker.add(hand.getCardRanks().get(x));
					}
				}
				hand.setKicker(kicker);
				return true;
			} else if (Collections.frequency(hand.getCardRanks(), hand.getCardRanks().get(i)) == 3) {
				hand.setTypeOfHand("Three of a Kind");
				hand.setHighHand(hand.getCardRanks().get(i));
				hand.setLowHand(0);
				for(int x = 0; x < 5; x++) {
					if(hand.getCardRanks().get(x) != hand.getHighHand()) {
						kicker.add(hand.getCardRanks().get(x));
					}
				}
				hand.setKicker(kicker);
				return true;
			}
		} 
		return false;
	} 

	// Sets kickers, high hands, low hands TESTED
	public static Boolean pair(Hand hand) {
		int x = 0;
		int highHand = 0;
		ArrayList<Integer> kicker = new ArrayList<Integer>();
		ArrayList<Integer> pairs = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			if (Collections.frequency(hand.getCardRanks(), hand.getCardRanks().get(i)) == 2) {
				x++;
				pairs.add(hand.getCardRanks().get(i));
				highHand = hand.getCardRanks().get(i);
			} else {
				kicker.add(hand.getCardRanks().get(i));
			}
		}
		if (x == 2) {
			hand.setTypeOfHand("One Pair");
			hand.setHighHand(highHand);
			hand.setKicker(kicker);
			return true;
		} else if (x == 4) {
			hand.setTypeOfHand("Two Pair");
			hand.setHighHand(highHand);
			hand.setKicker(kicker);
			int min = 99;
			int max = 0;
			for(int z = 0; z < pairs.size() - 1; z++) {
				min = Math.min(min, pairs.get(z));
				max = Math.max(max, pairs.get(z));
			}
			hand.setHighHand(max);
			hand.setLowHand(min);
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
