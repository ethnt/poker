import java.util.*;

/**
 * The test class HandTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HandTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class HandTest
     */
    public HandTest()
    {
    }
    
    public void testPair() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("3", "spades"));
        cards.add(new Card("5", "hearts"));
        cards.add(new Card("6", "spades"));
        cards.add(new Card("10", "diamonds"));
        Hand hand = new Hand(cards);
        
        assertEquals(true, hand.isPair());
    }
    
    public void testTwoPair() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("3", "spades"));
        cards.add(new Card("6", "hearts"));
        cards.add(new Card("6", "spades"));
        cards.add(new Card("10", "diamonds"));
        Hand hand = new Hand(cards);
        
        assertEquals(true, hand.isTwoPair());
    }
    
    public void testThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("3", "spades"));
        cards.add(new Card("3", "hearts"));
        cards.add(new Card("6", "spades"));
        cards.add(new Card("10", "diamonds"));
        Hand hand = new Hand(cards);
        
        assertEquals(true, hand.isThreeOfAKind());
    }
    
    public void testStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("4", "spades"));
        cards.add(new Card("5", "hearts"));
        cards.add(new Card("6", "spades"));
        cards.add(new Card("7", "diamonds"));
        Hand hand = new Hand(cards);
        
        assertEquals(true, hand.isStraight());
    }
    
    public void testFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("2", "clubs"));
        cards.add(new Card("4", "clubs"));
        cards.add(new Card("7", "clubs"));
        cards.add(new Card("8", "clubs"));
        cards.add(new Card("10", "clubs"));
        Hand hand = new Hand(cards);
        
        assertEquals(true, hand.isFlush());
    }
    
    public void testFullHouse() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("3", "diamonds"));
        cards.add(new Card("3", "spades"));
        cards.add(new Card("6", "clubs"));
        cards.add(new Card("6", "hearts"));
        Hand hand = new Hand(cards);
        
        assertEquals(true, hand.isFullHouse());
    }
    
    public void testFourOfAKind() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("3", "diamonds"));
        cards.add(new Card("3", "spades"));
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("6", "hearts"));
        Hand hand = new Hand(cards);
        
        assertEquals(true, hand.isFourOfAKind());
    }
    
    public void testStraightFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("2", "clubs"));
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("4", "clubs"));
        cards.add(new Card("5", "clubs"));
        cards.add(new Card("6", "clubs"));
        Hand hand = new Hand(cards);
        
        assertEquals(true, hand.isFourOfAKind());
    }
}

