package main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import pokerEnums.eSuits;

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
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(5, eSuits.HEARTS),
															   new Card(6, eSuits.HEARTS),
															   new Card(7, eSuits.HEARTS))));
		
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(11, eSuits.HEARTS),
				   											   new Card(10, eSuits.HEARTS),
				   											   new Card(1, eSuits.HEARTS),
				   											   new Card(12, eSuits.HEARTS),
				   											   new Card(13, eSuits.HEARTS))));
		
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
				   											   new Card(7, eSuits.HEARTS),
				   											   new Card(3, eSuits.HEARTS),
				   											   new Card(2, eSuits.HEARTS),
				   											   new Card(4, eSuits.HEARTS))));
		
		hand4.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(11, eSuits.CLUBS),
				   											   new Card(10, eSuits.SPADES),
				   											   new Card(1, eSuits.HEARTS),
				   											   new Card(12, eSuits.DIAMONDS),
				   											   new Card(13, eSuits.HEARTS))));
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
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
				   											   new Card(4, eSuits.HEARTS),
				   											   new Card(5, eSuits.HEARTS),
				   											   new Card(6, eSuits.HEARTS),
				   											   new Card(7, eSuits.HEARTS))));
		
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(5, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(3, eSuits.HEARTS))));
		
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(5, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(6, eSuits.HEARTS))));
		
		assertFalse(PokerHands.pair(hand1));
		assertTrue(PokerHands.pair(hand2));
		assertTrue(PokerHands.pair(hand3));
		assertTrue(hand1.getTypeOfHand()=="High Card");
		assertTrue(hand2.getTypeOfHand()=="Two Pair");
		assertTrue(hand3.getTypeOfHand()=="One Pair");
	}
	
	@Test
	public void rowTest(){
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
				   											   new Card(4, eSuits.HEARTS),
				   											   new Card(5, eSuits.HEARTS),
				   											   new Card(6, eSuits.HEARTS),
				   											   new Card(7, eSuits.HEARTS))));
	
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
															   new Card(4, eSuits.CLUBS),
															   new Card(3, eSuits.HEARTS),
															   new Card(3, eSuits.SPADES),
															   new Card(3, eSuits.HEARTS))));
	
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(5, eSuits.SPADES),
															   new Card(3, eSuits.CLUBS),
															   new Card(3, eSuits.SPADES))));
		assertFalse(PokerHands.row(hand1));
		assertTrue(PokerHands.row(hand2));
		assertTrue(PokerHands.row(hand3));
		assertTrue(hand1.getTypeOfHand()=="High Card");
		assertTrue(hand2.getTypeOfHand()=="Four of a Kind");
		assertTrue(hand3.getTypeOfHand()=="Three of a Kind");
	}
	
	@Test
	public void fullHouseTest(){
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
				   											   new Card(4, eSuits.HEARTS),
				   											   new Card(5, eSuits.HEARTS),
				   											   new Card(6, eSuits.HEARTS),
				   											   new Card(7, eSuits.HEARTS))));
		
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(5, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(3, eSuits.HEARTS))));
		
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(3, eSuits.HEARTS),
															   new Card(4, eSuits.CLUBS),
															   new Card(4, eSuits.HEARTS))));
		assertFalse(PokerHands.fullHouse(hand1));
		assertFalse(PokerHands.fullHouse(hand2));
		assertTrue(PokerHands.fullHouse(hand3));
		assertTrue(hand1.getTypeOfHand()=="High Card");
		assertTrue(hand2.getTypeOfHand()=="High Card");
		assertTrue(hand3.getTypeOfHand()=="Full House");
	}

}
