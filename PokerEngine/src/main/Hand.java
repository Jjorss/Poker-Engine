package main;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eHands;
import pokerEnums.eSuits;

public class Hand extends PokerHands {

	// The type of the hand, whether it is a flush, straight, one pair...
	private eHands typeOfHand = eHands.HIGHCARD;
	// The array that contains a bunch of hands.
	ArrayList<Hand> arrayOfHands = new ArrayList<Hand>();
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
	public Hand(Deck deck) {
		for (int i = 0; i < 5; i++) {
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
	// This method judges a hand and return an integer based on how good the
	// hand
	// is, the higher the integer the better the hand. Range: 1-10
	public static eHands judge(Hand hand) {
		if (PokerHands.straightOrFlush(hand)) {
			return hand.getTypeOfHand();
		} else if (PokerHands.fullHouse(hand)) {
			return hand.getTypeOfHand();
		} else if (PokerHands.row(hand)) {
			return hand.getTypeOfHand();
		} else if (PokerHands.pair(hand)) {
			return hand.getTypeOfHand();
		} else {
			hand.setHighHand(0);
			hand.setLowHand(0);
			hand.setKicker(hand.getCardRanks());
			hand.setTypeOfHand(eHands.HIGHCARD);
			return hand.getTypeOfHand();
		}

	}

	public static Hand judge(ArrayList<Hand> arrayOfHands) {
		ArrayList<eHands> typeOfHand = new ArrayList<eHands>();
		ArrayList<Integer> highHands = new ArrayList<Integer>();
		ArrayList<Integer> lowHands = new ArrayList<Integer>();
		int max = 0;
		int position = 0;
		Hand winner = null;
		for (int i = 0; i < arrayOfHands.size(); i++) {
			typeOfHand.add(Hand.judge(arrayOfHands.get(i)));
			highHands.add(arrayOfHands.get(i).getHighHand());
			lowHands.add(arrayOfHands.get(i).getLowHand());
		}
		for (int a = 0; a < arrayOfHands.size(); a++) {
			if (Collections.frequency(typeOfHand, typeOfHand.get(a)) >= 2) {
				// look at high hands
				if (Collections.frequency(highHands, highHands.get(a)) >= 2) {
					// look at low hands
					if (Collections.frequency(lowHands, lowHands.get(a)) >= 2) {
						// Best kicker
						System.out.println("Best kicker");
						for (int x = 0; x < arrayOfHands.size() - 1; x++) {
							for (int q = arrayOfHands.get(0).getKicker().size() - 1; q >= 0; q--) {
								if (arrayOfHands.get(x).getKicker().get(q) == 1) {
									winner = arrayOfHands.get(x);
								} else if (arrayOfHands.get(x + 1).getKicker().get(q) == 1) {
									winner = arrayOfHands.get(x + 1);
								} else if (arrayOfHands.get(x).getKicker().get(q) != arrayOfHands.get(x + 1).getKicker()
										.get(q)) {
									if (arrayOfHands.get(x).getKicker().get(q) > arrayOfHands.get(x + 1).getKicker()
											.get(q)) {
										winner = arrayOfHands.get(x);
									} else {
										winner = arrayOfHands.get(x + 1);
									}
								}
							}
						}

					} else {
						// best low hand
						System.out.println("Best low hand");
						for (int x = 0; x < lowHands.size(); x++) {
							max = Math.max(lowHands.get(x), max);
						}
						for (int y = 0; y < lowHands.size(); y++) {
							if (max == lowHands.get(y)) {
								position = y;
								break;
							}
						}
						winner = arrayOfHands.get(position);
					}
				} else {
					// best high hand
					System.out.println("Best high hand");
					for (int x = 0; x < highHands.size(); x++) {
						max = Math.max(highHands.get(x), max);
					}
					for (int y = 0; y < highHands.size(); y++) {
						if (max == highHands.get(y)) {
							position = y;
							break;
						}
					}
					winner = arrayOfHands.get(position);
				}
			} else {
				// best hand
				System.out.println("best hand");
				for (int x = 0; x < typeOfHand.size(); x++) {
					max = Math.max(typeOfHand.get(x).getScore(), max);
				}
				for (int y = 0; y < typeOfHand.size(); y++) {
					if (max == typeOfHand.get(y).getScore()) {
						position = y;
						break;
					}
				}

				winner = arrayOfHands.get(position);
			}
		}

		return winner;
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

	public void setTypeOfHand(eHands royalflush) {
		this.typeOfHand = royalflush;
	}

	public eHands getTypeOfHand() {
		return typeOfHand;
	}

	public ArrayList<Integer> getCardRanks() {
		return cardRanks;
	}

	public ArrayList<eSuits> getCardSuits() {
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
