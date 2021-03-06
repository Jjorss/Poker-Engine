package main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import pokerEnums.eHands;
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
		assertTrue(hand1.getTypeOfHand()==eHands.STRAIGHFLUSH);
		assertTrue(hand2.getTypeOfHand()==eHands.ROYALFLUSH);
		assertTrue(hand3.getTypeOfHand()==eHands.FLUSH);
		assertTrue(hand4.getTypeOfHand()==eHands.STRAIGHT);
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
		
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
															   new Card(4, eSuits.HEARTS),
															   new Card(5, eSuits.HEARTS),
															   new Card(4, eSuits.HEARTS),
															   new Card(6, eSuits.HEARTS))));
		
		assertFalse(PokerHands.pair(hand1));
		assertTrue(PokerHands.pair(hand2));
		assertTrue(PokerHands.pair(hand3));
		assertTrue(hand1.getTypeOfHand()==eHands.HIGHCARD);
		assertTrue(hand2.getTypeOfHand()==eHands.TWOPAIR);
		assertTrue(hand3.getTypeOfHand()==eHands.ONEPAIR);
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
		assertTrue(hand1.getTypeOfHand()==eHands.HIGHCARD);
		assertTrue(hand2.getTypeOfHand()==eHands.FOUROFAKIND);
		assertTrue(hand3.getTypeOfHand()==eHands.THREEOFAKIND);
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
		assertTrue(hand1.getTypeOfHand()==eHands.HIGHCARD);
		assertTrue(hand2.getTypeOfHand()==eHands.HIGHCARD);
		assertTrue(hand3.getTypeOfHand()==eHands.FULLHOUSE);
	}
	
	@Test
	public void testJudge() {
		System.out.println("Test one");
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(4, eSuits.HEARTS),
				   new Card(5, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS))));
		assertFalse(Hand.judge(hand1) == eHands.FULLHOUSE);
		assertTrue(Hand.judge(hand1) == eHands.ONEPAIR);
		System.out.println(Hand.judge(hand1));
		System.out.println(hand1.getTypeOfHand());
		System.out.println("Kicker " + hand1.getKicker());
		System.out.println("HighHand: " + hand1.getHighHand());
		System.out.println("LowHand: " + hand1.getLowHand());
		System.out.println("----------");
		
		System.out.println("Test Two");
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(4, eSuits.HEARTS),
				   new Card(3, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS))));
		assertFalse(Hand.judge(hand2) == eHands.FULLHOUSE);
		assertTrue(Hand.judge(hand2) == eHands.TWOPAIR);
		System.out.println(Hand.judge(hand2));
		System.out.println(hand2.getTypeOfHand());
		System.out.println("Kicker " + hand2.getKicker());
		System.out.println("HighHand: " + hand2.getHighHand());
		System.out.println("LowHand: " + hand2.getLowHand());
		System.out.println("----------");
		
		System.out.println("Test Three");
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(3, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS))));
		assertFalse(Hand.judge(hand3) == eHands.FULLHOUSE);
		assertTrue(Hand.judge(hand3) == eHands.THREEOFAKIND);
		System.out.println(Hand.judge(hand3));
		System.out.println(hand3.getTypeOfHand());
		System.out.println("HighHand: " + hand3.getHighHand());
		System.out.println("LowHand: " + hand3.getLowHand());
		System.out.println(hand3.getKicker());
		System.out.println("----------");
		
		System.out.println("Test Four");
		hand4.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(3, eSuits.HEARTS),
				   new Card(3, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS))));
		assertFalse(Hand.judge(hand4) == eHands.FULLHOUSE);
		assertTrue(Hand.judge(hand4) == eHands.FOUROFAKIND);
		System.out.println(Hand.judge(hand4));
		System.out.println(hand4.getTypeOfHand());
		System.out.println("HighHand: " + hand4.getHighHand());
		System.out.println("LowHand: " + hand4.getLowHand());
		System.out.println(hand4.getKicker());
		System.out.println("----------");
		
		System.out.println("Test Five");
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(7, eSuits.CLUBS),
				   new Card(8, eSuits.HEARTS),
				   new Card(9, eSuits.HEARTS),
				   new Card(10, eSuits.CLUBS),
				   new Card(11, eSuits.HEARTS))));
		assertFalse(Hand.judge(hand1) == eHands.FULLHOUSE);
		assertTrue(Hand.judge(hand1) == eHands.STRAIGHT);
		System.out.println(Hand.judge(hand1));
		System.out.println(hand1.getTypeOfHand());
		System.out.println("HighHand: " + hand1.getHighHand());
		System.out.println("LowHand: " + hand1.getLowHand());
		System.out.println(hand1.getKicker());
		System.out.println("----------");
		
		System.out.println("Test Six");
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(8, eSuits.CLUBS),
				   new Card(9, eSuits.CLUBS),
				   new Card(4, eSuits.CLUBS),
				   new Card(1, eSuits.CLUBS))));
		assertFalse(Hand.judge(hand2) == eHands.FULLHOUSE);
		assertTrue(Hand.judge(hand2) == eHands.FLUSH);
		System.out.println(Hand.judge(hand2));
		System.out.println(hand2.getTypeOfHand());
		System.out.println("HighHand: " + hand2.getHighHand());
		System.out.println("LowHand: " + hand2.getLowHand());
		System.out.println(hand2.getKicker());
		System.out.println("----------");
		
		System.out.println("Test Seven");
		hand3.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(2, eSuits.CLUBS),
				   new Card(4, eSuits.CLUBS),
				   new Card(5, eSuits.CLUBS),
				   new Card(1, eSuits.CLUBS))));
		assertFalse(Hand.judge(hand3) == eHands.FULLHOUSE);
		assertTrue(Hand.judge(hand3) == eHands.STRAIGHFLUSH);
		System.out.println(Hand.judge(hand3));
		System.out.println(hand3.getTypeOfHand());
		System.out.println("HighHand: " + hand3.getHighHand());
		System.out.println("LowHand: " + hand3.getLowHand());
		System.out.println(hand3.getKicker());
		System.out.println("----------");
		
		System.out.println("Test Eight");
		hand4.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(10, eSuits.CLUBS),
				   new Card(11, eSuits.CLUBS),
				   new Card(12, eSuits.CLUBS),
				   new Card(13, eSuits.CLUBS),
				   new Card(1, eSuits.CLUBS))));
		assertFalse(Hand.judge(hand4) == eHands.FULLHOUSE);
		assertTrue(Hand.judge(hand4) == eHands.ROYALFLUSH);
		System.out.println(Hand.judge(hand4));
		System.out.println(hand4.getTypeOfHand());
		System.out.println("HighHand: " + hand4.getHighHand());
		System.out.println("LowHand: " + hand4.getLowHand());
		System.out.println(hand4.getKicker());
		System.out.println("----------");
		
		System.out.println("Test Nine");
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(1, eSuits.DIAMONDS),
				   new Card(1, eSuits.HEARTS),
				   new Card(1, eSuits.CLUBS),
				   new Card(3, eSuits.SPADES),
				   new Card(3, eSuits.CLUBS))));
		assertFalse(Hand.judge(hand1) == eHands.ONEPAIR);
		assertTrue(Hand.judge(hand1) == eHands.FULLHOUSE);
		System.out.println(Hand.judge(hand1));
		System.out.println(hand1.getTypeOfHand());
		System.out.println("HighHand: " + hand1.getHighHand());
		System.out.println("LowHand: " + hand1.getLowHand());
		System.out.println(hand1.getKicker());
		System.out.println("----------");
		
		System.out.println("Test Ten");
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.DIAMONDS),
				   new Card(4, eSuits.HEARTS),
				   new Card(5, eSuits.CLUBS),
				   new Card(6, eSuits.SPADES),
				   new Card(13, eSuits.CLUBS))));
		assertFalse(Hand.judge(hand2) == eHands.ONEPAIR);
		assertTrue(Hand.judge(hand2) == eHands.HIGHCARD);
		System.out.println(Hand.judge(hand2));
		System.out.println(hand2.getTypeOfHand());
		System.out.println("HighHand: " + hand2.getHighHand());
		System.out.println("LowHand: " + hand2.getLowHand());
		System.out.println(hand2.getKicker());
		System.out.println("----------");
	}
	
	@Test
	public void JudgeHands() {
		System.out.println("---------------------JudgeHands TEST---------------");
		System.out.println("Test One");
		ArrayList<Hand> arrayOfHands = new ArrayList<Hand>();
		arrayOfHands.add(hand1);
		arrayOfHands.add(hand2);
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(4, eSuits.HEARTS),
				   new Card(5, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS))));
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(7, eSuits.CLUBS),
				   new Card(4, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS))));
		System.out.println(Hand.judge(hand1));
		System.out.println(Hand.judge(hand2));
		System.out.println("Hand2");
		assertTrue(Hand.judge(arrayOfHands) == hand2);
		System.out.println("----------");
		
		System.out.println("Test Two");
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(9, eSuits.HEARTS))));
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS))));
		System.out.println(Hand.judge(hand1));
		System.out.println(Hand.judge(hand2));
		System.out.println("Hand1");
		assertTrue(Hand.judge(arrayOfHands) == hand1);
		assertFalse(Hand.judge(arrayOfHands) == hand2);
		System.out.println("----------");
		
		System.out.println("Test Three");
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(9, eSuits.HEARTS))));
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(2, eSuits.CLUBS),
				   new Card(2, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS))));
		System.out.println(Hand.judge(hand1));
		System.out.println(Hand.judge(hand2));
		System.out.println(hand1.getHighHand());
		System.out.println(hand2.getHighHand());
		System.out.println("Hand1");
		Hand.judge(arrayOfHands);
		assertTrue(Hand.judge(arrayOfHands) == hand1);
		assertFalse(Hand.judge(arrayOfHands) == hand2);
		System.out.println("----------");
		
		System.out.println("Test Four");
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(5, eSuits.HEARTS),
				   new Card(2, eSuits.HEARTS))));
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(5, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS))));
		System.out.println(Hand.judge(hand1));
		System.out.println(Hand.judge(hand2));
		System.out.println(hand1.getKicker());
		System.out.println(hand2.getKicker());
		System.out.println("Hand2");
		Hand.judge(arrayOfHands);
		assertTrue(Hand.judge(arrayOfHands) == hand2);
		assertFalse(Hand.judge(arrayOfHands) == hand1);
		System.out.println("----------");
		
		System.out.println("Test Five");
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(2, eSuits.HEARTS))));
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(3, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(7, eSuits.HEARTS),
				   new Card(4, eSuits.HEARTS))));
		System.out.println(Hand.judge(hand1));
		System.out.println(Hand.judge(hand2));
		System.out.println(hand1.getKicker());
		System.out.println(hand2.getKicker());
		System.out.println("Hand2");
		Hand.judge(arrayOfHands);
		assertTrue(Hand.judge(arrayOfHands) == hand2);
		assertFalse(Hand.judge(arrayOfHands) == hand1);
		System.out.println("----------");
		
		System.out.println("Test Six");
		hand1.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(4, eSuits.HEARTS),
				   new Card(5, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS),
				   new Card(13, eSuits.HEARTS))));
		hand2.setCardsInHand(new ArrayList<Card>(Arrays.asList(new Card(3, eSuits.CLUBS),
				   new Card(4, eSuits.HEARTS),
				   new Card(8, eSuits.HEARTS),
				   new Card(6, eSuits.HEARTS),
				   new Card(1, eSuits.HEARTS))));
		System.out.println(Hand.judge(hand1));
		System.out.println(Hand.judge(hand2));
		System.out.println(hand1.getKicker());
		System.out.println(hand2.getKicker());
		System.out.println("Hand1");
		Hand.judge(arrayOfHands);
		assertTrue(Hand.judge(arrayOfHands) == hand2);
		assertFalse(Hand.judge(arrayOfHands) == hand1);
		System.out.println("----------");
	}

}
