import java.util.*;

/**
 * A playing card.
 * 
 * @author (Ethan Turkeltaub)
 * @version (0.1.0)
 */

public class Card implements Comparable<Card> {
	private int value;
	private String suit;

	/**
	 * Constructor for Card. Value (v) is a number from 2-10, J, Q, K, or A. Suit (s) is hearts, spades, clubs, or diamonds.
	 */
	public Card(String v, String s) {
		if (v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5") || v.equals("6") || v.equals("7") || v.equals("8") || v.equals("9") || v.equals("10") || v.equals("11") || v.equals("12") || v.equals("13") || v.equals("14")) {
			value = Integer.parseInt(v);
		} else {
			if (v.equals("J")) {
				value = 11;
			} else if (v.equals("Q")) {
				value = 12;
			} else if (v.equals("K")) {
				value = 13;
			} else if (v.equals("A")) {
				value = 14;
			}
		}
		
		suit = s;
	}
	
	/**
	 * Get the value of the card (2-10, J, Q, K, A).
	 * 
	 * @return   The value.
	 */
	public String value() {
		String result = "";
		
		// If a number card.
		if (value >= 2 && value <= 10) {
			result = Integer.toString(value);
		}
		
		// If a face card.
		else if (value >= 11 && value <= 14) {
			if (value == 11) {
				result = "J";
			} else if (value == 12) {
				result = "Q";
			} else if (value == 13) {
				result = "K";
			} else if (value == 14) {
				result = "A";
			} else {
				result = "WTF";
			}
		}
		
		return result;
	}
	
	/**
	 * Get the raw numerical value of the value.
	 * 
	 * @return   The value in numerical form (2-10, jack is 11, queen is 12, king is 13, ace is 14).
	 */
	public int intValue() {
		return value;
	}
	
	/**
	 * Get the suit (hearts, spades, clubs, diamonds).
	 * 
	 * @return   The suit (hearts, spades, clubs, diamonds).
	 */
	public String suit() {
		return suit;
	}
	
	/**
	 * Check if two cards are equal.
	 * 
	 * @param   c   Another card.
	 * @return      A boolean value.
	 */
	public boolean equals(Card c) {
		boolean result = false;
		
		if (this.intValue() == c.intValue()) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Compare two cards.
	 * 
	 * @param   c   Another card.
	 * @return      An integer. If 0, then they are equal, -1 if the current card (the one calling the method) is weaker than the other, and 1 if the card calling the method is better.
	 */
	public int compareTo(Card c) {
		int result = 0;
		
		if (this.intValue() > c.intValue()) {
			result = 1;
		} else if (c.intValue() > this.intValue()) {
			result = -1;
		} else {
			// Let it be.
		}
		
		return result;
	}
	
	public String toString() {
		return value() + " of " + suit();
	}
}
