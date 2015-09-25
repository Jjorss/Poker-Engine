package pokerEnums;

public enum eSuits {

	HEARTS(1), SPADES(2), CLUBS(3), DIAMONDS(4), WILD(99);
	
	private eSuits(final int suit) {
		this.suit = suit;
	}
	
	private int suit;
	

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

}
