package pokerEnums;

public enum eHands {
	HIGHCARD(5), ONEPAIR(10), TWOPAIR(15), THREEOFAKIND(20), 
	STRAIGHT(25), FLUSH(30), FULLHOUSE(35), FOUROFAKIND(40),
	STRAIGHFLUSH(45), ROYALFLUSH(50);
	
	private eHands(final int score) {
		this.score = score;
	}
	
	private int score;
	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
