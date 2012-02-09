// Work in progress.

/**
 * The test class CardTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CardTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class CardTest
     */
    public CardTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }
    
    // Make separate tests for this.
    public void testComparing()
    {
        Card c1 = new Card("2", "hearts");
        Card c2 = new Card("A", "spades");
        assertEquals(-1, c1.compareTo(c2));
        assertEquals(1, c2.compareTo(c1));
        Card c3 = new Card("2", "hearts");
        assertEquals(0, c3.compareTo(c1));
    }
}