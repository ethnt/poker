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

    public void testRanking()
    {
        ArrayList<Card> fullHouse = new ArrayList<Card>();
        fullHouse.add(new Card("3", "clubs"));
        fullHouse.add(new Card("3", "spades"));
        fullHouse.add(new Card("3", "diamonds"));
        fullHouse.add(new Card("6", "clubs"));
        fullHouse.add(new Card("6", "hearts"));
        
        Hand fullHouseHand = new Hand(fullHouse);
        
        assertEquals(6, fullHouseHand.getRanking());
    }
}

