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