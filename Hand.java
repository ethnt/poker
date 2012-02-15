import java.util.*;

/**
 * A hand of Cards for a Player.
 * 
 * @author (Ethan Turkeltaub)
 * @version (0.1.0)
 */
public class Hand implements Comparable<Hand> {
	private ArrayList<Card> hand;
	private int[] values;
	private String[] suits;
	
	/**
	 * Construct a Hand and give the Hand some Cards.
	 */
	public Hand(ArrayList<Card> cards) {
		hand = cards;
		values = values();
		suits = suits();
		
		Arrays.sort(values);
		Arrays.sort(suits);
	}
	
	public ArrayList<Card> cards() {
		return hand;
	}
	
	public int compareTo(Hand other) {
	    int result = 0;
	    if (this.getRanking() > other.getRanking()) {
	        result = 1;
	       }
	    else if (other.getRanking() > this.getRanking()) {
	        result = -1;
	       }
	    else{
	        int[] mine = this.values();
	        int[] theirs = other.values();
	       }
	    return result;
	}
	
	public double getRanking() {
	    double ranking = 0;
	    if (isStraightFlush()>8.0) {
	        ranking = isStraightFlush();
	       }
	    else if (isFourOfAKind()>7.0) {
	        ranking = isFourOfAKind();
	       }
	    else if (isFullHouse()>6.0) {
	        ranking = isFullHouse();
	       }
	    else if (isFlush()>5.0) {
	        ranking = isFlush();
	       }
	    else if (isStraight()>4.0) {
	        ranking = isStraight();
	       }
	    else if (isThreeOfAKind()>3.0) {
	        ranking = isThreeOfAKind();
	       }
	    else if (isTwoPair()>2.0) {
	        ranking = isTwoPair();
	       }
	    else if (isPair()>1.0) {
	        ranking = isPair();
	       }
	    else {
	        /* WTF */
	       }
	    return ranking;
	}
	
	/* -------------------------------------------*/
	
	// Generate array of card values (2-14).
	private int[] values() {
		int[] result = new int[5];
		
		for (int i = 0; i < hand.size(); i++) {
			result[i] = hand.get(i).intValue();
		}
		
		return result;
	}
	
	// Generate array of card suits (spades, diamonds, clubs, hearts).
	private String[] suits() {
		String[] result = new String[5];
		
		for (int i = 0; i < hand.size(); i++) {
			result[i] = hand.get(i).suit();
		}
		
		return result;
	}
	
	public double isPair() {
		double result = 0;
		
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) { // Compare the current value at i to every other card.
				if (i != j) { // Stop if from comparing itself.
					if (values[i] == values[j]) {
						result = 1+i*.01;
					}
				}
			}
		}
		
		return result;
	}
	
	public double isTwoPair() {
		double result = 0;
		double value = 0.0;
		int counter = 0; // Number of pairs.
		
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) { // Compare the current value at i to every other card.
				if (i != j) { // Stop if from comparing itself.
					if (values[i] == values[j]) {
						counter++; // If there is a pair, increase.
						value = i*.01;
					}
				}
			}
		}
		
		if (counter == 2) {
			result = counter + value;
		}
		
		return result;
	}
	
	public double isThreeOfAKind() {
		double result = 0;
		double value = 0;
		int counter = 0; // Number of alike cards.
		
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) { // Compare the current value at i to every other card.
				if (i != j) {
					if (values[i] == values[j]) {
						counter++;
						value = i*.01;
					}
				}
			}
		}
		
		if (counter == 6) {
			result = 3+value;
		}
		
		return result;
	}
	
	public double isStraight() {
		double result = 0;
		
		for (int i = 0; i < values.length - 1; i++){
        	if(values[i] == values[i + 1] - 1) {
            	result = 4 +(i+1)*.01;
        	}

    	}
		
		return result;
	}
	
	public double isFlush() {
		double result = 0;
		
		String suit = suits[0]; // The suit to compare to.
		
		for (int i = 0; i < suits.length; i++) {
			result = 5+i*.01;
		    if (suits[i].equals(suit) == false) {
				result = 0;
			}
		}
		
		return result;
	}
	
	public double isFullHouse() {
		double result = 0;
		
		// TO-DO
		
		return result;
	}
	
	public double isFourOfAKind() { // Same code as isThreeOfAKind(), except the counter must equal 4.
		double result = 0;
		double value = 0;
		int counter = 0; // Number of alike cards.
		
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) { // Compare the current value at i to every other card.
				if (i != j) {
					if (values[i] == values[j]) {
						counter++;
						value = i*.01;
					}
				}
			}
		}
		
		if (counter == 12) {
			result = 7+value;
		}
		
		return result;
	}
	
	public double isStraightFlush() {
		double result = 0;
		
		if (isStraight()>4 && isFlush()>5) {
			result = 8+isStraight()-4.0;
		}
		
		return result;
	}
	
	public String toString(){
	    String result="";
	    result += hand.get(0).toString();
	    for (int i=1;i<5;i++){
	        result+= ", "+ hand.get(i).toString();
	       }
	       return result;
	}
}
