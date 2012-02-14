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
    
    public void testPairRanking() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("6", "hearts"));
        cards.add(new Card("7", "spades"));
        cards.add(new Card("10", "diamonds"));
        Hand hand = new Hand(cards);
        
        assertEquals(1, hand.isTwoPair());
    }
    
    public void testTwoPairRanking() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("3", "spades"));
        cards.add(new Card("6", "hearts"));
        cards.add(new Card("6", "spades"));
        cards.add(new Card("10", "diamonds"));
        Hand hand = new Hand(cards);
        
        assertEquals(2, hand.getRanking());
    }
    
    public void testFullHouseRanking() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("3", "clubs"));
        cards.add(new Card("3", "spades"));
        cards.add(new Card("3", "diamonds"));
        cards.add(new Card("6", "clubs"));
        cards.add(new Card("6", "hearts"));
        
        Hand hand = new Hand(cards);
        
        assertEquals(6, hand.getRanking());
    }
}

