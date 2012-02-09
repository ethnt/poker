/**
 * The test class CardTest.
 *
 * @author  (Ethan Turkeltaub)
 * @version (0.1.0)
 */
public class CardTest extends junit.framework.TestCase {
		
    public CardTest() { }

    protected void setUp() { }

    protected void tearDown() { }
    
	/**
     * Test non-integer value of face card.
     */
	public void testValue() {
        Card c1 = new Card("J", "hearts");
        assertEquals("J", c1.value());
    }

    /**
     * Test integer value of face card.
     */
	public void testIntValue() {
		Card c1 = new Card("J", "hearts");
		assertEquals("11", c1.intValue());
	}
	
    /**
     * Test the suit.
     */
	public void testSuit() {
		Card c1 = new Card("A", "spades")
		assertEquals("spades", c1.suit());
	}
	
    /**
     * Test stronger card.
     */
	public void testStrongerCard() {
		Card c1 = new Card("A", "spades");
		Card c2 = new Card("2", "hearts");
		
		assertEquals(1, c1.compareTo(c2));
	}

    /**
     * Test weaker card.
     */
	public void testWeakerCard() {
		Card c1 = new Card("2", "hearts");
		Card c2 = new Card("A", "spades");
		
		assertEquals(-1, c1.compareTo(c2));
	}
	
	/**
     * Test equal card.
     */
	public void testEqualCard() {
		Card c1 = new Card("2", "hearts");
		Card c2 = new Card("2", "clubs");
		
		assertEquals(0, c1.compareTo(c2));
	}


}
