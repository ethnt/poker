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

	public void testShuffle() {
		Deck d1 = new Deck();
		
		String initial = d1.toString();
		d1.shuffle();
		String result = d1.toString();
		
		assertNotSame(initial, result);
	}
	
	public void testDraw() {
		Deck d1 = new Deck();
		
		d1.draw();
		
		assertEquals(51, d1.cards().size());
	}
	
	public void testEquals() {
		Deck d1 = new Deck();
		Deck d2 = new Deck();
		
		assertEquals(d1, d2);
	}
}	
