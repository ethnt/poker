import java.util.*;

/**
 * The test class DeckTest.
 *
 * @author  (Ethan Turkeltaub)
 * @version (0.1.0)
 */
public class DeckTest extends junit.framework.TestCase {
		
	public DeckTest() { }

	protected void setUp() { }

	protected void tearDown() { }

	/**
	 * Test the shuffling.
	 */
	public void testShuffle() {
		Deck d1 = new Deck();
		
		String initial = d1.toString();
		d1.shuffle();
		String result = d1.toString();
		
		assertNotSame(initial, result);
	}

	/**
	 * Test the drawing of a card.
	 */
	public void testDraw() {
		Deck d1 = new Deck();
		
		Card c1 = d1.draw();
		
		assertEquals(51, d1.cards().size());
	}
	
	/**
	 * Test equivalent decks.
	 */
	public void testEquals() {
		Deck d1 = new Deck();
		Deck d2 = new Deck();
		
		assertEquals(true, d1.equals(d2));
	}
}	
