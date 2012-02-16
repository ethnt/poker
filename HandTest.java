import java.util.*;

/**
 * The unit testing of Hand.
 *
 * @author  (Ethan Turkeltaub & Brett Morris)
 * @version (0.1.0)
 */
public class HandTest extends junit.framework.TestCase {
	private ArrayList<Card> pairCards;
	private ArrayList<Card> twoPairCards;
	private ArrayList<Card> threeOfAKindCards;
	private ArrayList<Card> straightCards;
	private ArrayList<Card> flushCards;
	private ArrayList<Card> fullHouseCards;
	private ArrayList<Card> fourOfAKindCards;
	private ArrayList<Card> straightFlushCards;
	
	private Hand pair;
	private Hand twoPair;
	private Hand threeOfAKind;
	private Hand straight;
	private Hand flush;
	private Hand fullHouse;
	private Hand fourOfAKind;
	private Hand straightFlush;	

	public HandTest() {
		pairCards = new ArrayList<Card>();
		twoPairCards = new ArrayList<Card>();
		threeOfAKindCards = new ArrayList<Card>();
		straightCards = new ArrayList<Card>();
		flushCards = new ArrayList<Card>();
		fullHouseCards = new ArrayList<Card>();
		fourOfAKindCards = new ArrayList<Card>();
		straightFlushCards = new ArrayList<Card>();
		
		pairCards.add(new Card("3", "clubs"));
		pairCards.add(new Card("3", "spades"));
		pairCards.add(new Card("5", "hearts"));
		pairCards.add(new Card("6", "spades"));
		pairCards.add(new Card("10", "diamonds"));
		
		twoPairCards.add(new Card("3", "clubs"));
		twoPairCards.add(new Card("3", "spades"));
		twoPairCards.add(new Card("6", "hearts"));
		twoPairCards.add(new Card("6", "spades"));
		twoPairCards.add(new Card("10", "diamonds"));
		
		threeOfAKindCards.add(new Card("3", "clubs"));
		threeOfAKindCards.add(new Card("3", "spades"));
		threeOfAKindCards.add(new Card("3", "hearts"));
		threeOfAKindCards.add(new Card("6", "spades"));
		threeOfAKindCards.add(new Card("10", "diamonds"));
		
		straightCards.add(new Card("3", "clubs"));
		straightCards.add(new Card("4", "spades"));
		straightCards.add(new Card("5", "hearts"));
		straightCards.add(new Card("6", "spades"));
		straightCards.add(new Card("7", "diamonds"));
		
		flushCards.add(new Card("2", "clubs"));
		flushCards.add(new Card("4", "clubs"));
		flushCards.add(new Card("7", "clubs"));
		flushCards.add(new Card("8", "clubs"));
		flushCards.add(new Card("10", "clubs"));
		
		fullHouseCards.add(new Card("3", "clubs"));
		fullHouseCards.add(new Card("3", "diamonds"));
		fullHouseCards.add(new Card("3", "spades"));
		fullHouseCards.add(new Card("6", "clubs"));
		fullHouseCards.add(new Card("6", "hearts"));
		
		fourOfAKindCards.add(new Card("3", "clubs"));
		fourOfAKindCards.add(new Card("3", "diamonds"));
		fourOfAKindCards.add(new Card("3", "spades"));
		fourOfAKindCards.add(new Card("3", "clubs"));
		fourOfAKindCards.add(new Card("6", "hearts"));
		
		straightFlushCards.add(new Card("6", "clubs"));
		straightFlushCards.add(new Card("7", "clubs"));
		straightFlushCards.add(new Card("8", "clubs"));
		straightFlushCards.add(new Card("9", "clubs"));
		straightFlushCards.add(new Card("10", "clubs"));
		
		pair = new Hand(pairCards);
		twoPair = new Hand(twoPairCards);
		threeOfAKind = new Hand(threeOfAKindCards);
		straight = new Hand(straightCards);
		flush = new Hand(flushCards);
		fullHouse = new Hand(fullHouseCards);
		fourOfAKind = new Hand(fourOfAKindCards);
		straightFlush = new Hand(straightFlushCards);
	}
	
	/**
	 * Test pair ranking.
	 */
	public void testPair() {
		assertEquals(1.03, pair.isPair());
	}
	
	/**
	 * Test two pair ranking.
	 */
	public void testTwoPair() {
		assertEquals(2.06, twoPair.isTwoPair());
	}
	
	/**
	 * Test three-of-a-kind ranking.
	 */
	public void testThreeOfAKind() {
		assertEquals(3.03, threeOfAKind.isThreeOfAKind());
	}
	
	/**
	 * Test straight ranking.
	 */
	public void testStraight() {
		assertEquals(4.07, straight.isStraight());
	}
	
	/**
	 * Test flush ranking.
	 */
	public void testFlush() {
		assertEquals(5.10, flush.isFlush());
	}
	
	/**
	 * Test full house ranking.
	 */
	public void testFullHouse() {
		assertEquals(6.06, fullHouse.isFullHouse());
	}
	
	/**
	 * Test four-of-a-kind ranking.
	 */
	public void testFourOfAKind() {
		assertEquals(7.03, fourOfAKind.isFourOfAKind());
	}
	
	/**
	 * Test straight flush ranking.
	 */
	public void testStraightFlush() {
		assertEquals(8.1, straightFlush.isStraightFlush());
	}
	
	/**
	 * Test rank of a hand.
	 */
	public void testNumericalRankings() {
		assertEquals(1.03, pair.getRanking());
		assertEquals(2.06, twoPair.getRanking());
		assertEquals(3.03, threeOfAKind.getRanking());
		assertEquals(4.07, straight.getRanking());
		assertEquals(5.10, flush.getRanking());
		assertEquals(6.06, fullHouse.getRanking());
		assertEquals(7.03, fourOfAKind.getRanking());
		assertEquals(8.10, straightFlush.getRanking());
	}
}

