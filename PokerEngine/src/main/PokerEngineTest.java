package main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PokerEngineTest {
	
	Deck deck1;
	Hand hand1;
	Hand hand2;
	Hand hand3;
	Hand hand4;
	
	@Before
	public void setUp() {
		deck1 = new Deck(false);
		hand1 = new Hand(deck1);
		hand2 = new Hand(deck1);
		hand3 = new Hand(deck1);
		hand4 = new Hand(deck1);
		
	}
	
	@Test
	public void straightOrFlushTest() {
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
															   new Card(4, "Heart"),
															   new Card(5, "Heart"),
															   new Card(6, "Heart"),
															   new Card(7, "Heart"))));
		
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(11, "Heart"),
				   											   new Card(10, "Heart"),
				   											   new Card(1, "Heart"),
				   											   new Card(12, "Heart"),
				   											   new Card(13, "Heart"))));
		
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
				   											   new Card(7, "Heart"),
				   											   new Card(3, "Heart"),
				   											   new Card(2, "Heart"),
				   											   new Card(4, "Heart"))));
		
		hand4.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(11, "Club"),
				   											   new Card(10, "Spade"),
				   											   new Card(1, "Heart"),
				   											   new Card(12, "Diamond"),
				   											   new Card(13, "Heart"))));
		assertTrue(PokerHands.straightOrFlush(hand1));
		assertTrue(PokerHands.straightOrFlush(hand2));
		assertTrue(PokerHands.straightOrFlush(hand3));
		assertTrue(PokerHands.straightOrFlush(hand4));
		assertTrue(hand1.getTypeOfHand()=="Straight Flush");
		assertTrue(hand2.getTypeOfHand()=="Royal Flush");
		assertTrue(hand3.getTypeOfHand()=="Flush");
		assertTrue(hand4.getTypeOfHand()=="Straight");
	}
	
	@Test
	public void pairTest(){
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
				   											   new Card(4, "Heart"),
				   											   new Card(5, "Heart"),
				   											   new Card(6, "Heart"),
				   											   new Card(7, "Heart"))));
		
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
															   new Card(4, "Heart"),
															   new Card(5, "Heart"),
															   new Card(4, "Heart"),
															   new Card(3, "Heart"))));
		
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
															   new Card(4, "Heart"),
															   new Card(5, "Heart"),
															   new Card(4, "Heart"),
															   new Card(6, "Heart"))));
		
		assertFalse(PokerHands.pair(hand1));
		assertTrue(PokerHands.pair(hand2));
		assertTrue(PokerHands.pair(hand3));
		assertTrue(hand1.getTypeOfHand()=="High Card");
		assertTrue(hand2.getTypeOfHand()=="Two Pair");
		assertTrue(hand3.getTypeOfHand()=="One Pair");
	}
	
	@Test
	public void rowTest(){
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
				   											   new Card(4, "Heart"),
				   											   new Card(5, "Heart"),
				   											   new Card(6, "Heart"),
				   											   new Card(7, "Heart"))));
	
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
															   new Card(4, "Club"),
															   new Card(3, "Heart"),
															   new Card(3, "Spade"),
															   new Card(3, "Heart"))));
	
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
															   new Card(4, "Heart"),
															   new Card(5, "Spade"),
															   new Card(3, "Club"),
															   new Card(3, "Spade"))));
		assertFalse(PokerHands.row(hand1));
		assertTrue(PokerHands.row(hand2));
		assertTrue(PokerHands.row(hand3));
		assertTrue(hand1.getTypeOfHand()=="High Card");
		assertTrue(hand2.getTypeOfHand()=="Four of a Kind");
		assertTrue(hand3.getTypeOfHand()=="Three of a Kind");
	}
	
	@Test
	public void fullHouseTest(){
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
				   											   new Card(4, "Heart"),
				   											   new Card(5, "Heart"),
				   											   new Card(6, "Heart"),
				   											   new Card(7, "Heart"))));
		
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
															   new Card(4, "Heart"),
															   new Card(5, "Heart"),
															   new Card(4, "Heart"),
															   new Card(3, "Heart"))));
		
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, "Heart"),
															   new Card(4, "Heart"),
															   new Card(3, "Heart"),
															   new Card(4, "Club"),
															   new Card(4, "Heart"))));
		assertFalse(PokerHands.fullHouse(hand1));
		assertFalse(PokerHands.fullHouse(hand2));
		assertTrue(PokerHands.fullHouse(hand3));
		assertTrue(hand1.getTypeOfHand()=="High Card");
		assertTrue(hand2.getTypeOfHand()=="High Card");
		assertTrue(hand3.getTypeOfHand()=="Full House");
	}

}
