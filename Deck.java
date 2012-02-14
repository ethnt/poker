import java.util.*;

/**
 * A deck of playing cards.
 * 
 * @author (Brett Morris)
 * @version (0.1.0)
 */

public class Deck {
	private ArrayList<Card> deck;
	
	/**
	 * Constructor for Deck. Makes a normal deck.
	 */
	public Deck() {
		deck = new ArrayList<Card>();

		for (int i = 2; i < 15; i++) {
			deck.add(new Card("" + i, "spades"));
			deck.add(new Card("" + i, "diamonds"));
			deck.add(new Card("" + i, "clubs"));
			deck.add(new Card("" + i, "hearts"));
		}
	}
	
	/**
	 * Shuffle the deck. Randomly re-orders the cards.
	 * 
	 * @return   void
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	 * Draw a Card from the deck. Removes from the "top" (beginning of ArrayList).
	 * 
	 * @return   A Card object from the deck.
	 */
	public Card draw() {
		return deck.remove(0);
	}
	
	/**
	 * Check if two decks are the same.
	 * 
	 * @param   other   Another deck of cards.
	 * @return          True or false.
	 */
	public boolean equals(Deck other) {
		return this.toString().equals(other.toString());
	}
	
	/**
	 * Get the ArrayList of Cards.
	 *
	 * @return   The Cards.
	 */
	public ArrayList<Card> cards() {
		return deck;
	}
	
	/**
	 * Get the string representation of a Deck.
	 * 
	 * @return   A string representation of a Deck.
	 */
	public String toString() {
		String result = "";
		
		for (int i = 0; i < 52; i++) {
			result += deck.get(i).value() + " of " + deck.get(i).suit() + " ";
			
			if (i < 51) {
				result += "--";
			}
		}
		
		return result;
	}
}
