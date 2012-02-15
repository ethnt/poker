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
    
    public boolean isPair() {
        boolean result = false;
        
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                result = true;
            }
        }
        
        return result;
    }
    
    public boolean isTwoPair() {
        boolean result = false;
        int counter = 0; // Number of pairs.
        
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                counter++;
            }
        }
        
        if (counter == 2) {
            result = true;
        }
        
        return result;
    }
    
    public boolean isThreeOfAKind() {
        boolean result = false;
        int counter = 0; // Number of alike cards.
       
        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
                result = true;
            }
        }
        
        return result;
    }
    
    public boolean isStraight() {
        boolean result = false;
        
        for (int i = 0; i < values.length - 1; i++){
            if(values[i] == values[i + 1] - 1) {
                result = true;
            } else {
                result = false;
            }
        }
        
        return result;
    }
    
    public boolean isFlush() {
        boolean result = true;
        
        String suit = suits[0]; // The suit to compare to.
        
        for (int i = 0; i < suits.length; i++) {
            if (suits[i].equals(suit) == false) {
                result = false;
            }
        }
        
        return result;
    }
    
    public boolean isFullHouse() {
        boolean result = false;
        int oneCard = values[0];
        int twoCard = values[3];
        
        int oneCounter = 0;
        int twoCounter = 0;
        
        for (int i = 1; i < 3; i++) {
            if (values[i] == oneCard) {
                oneCounter++;
            }
        }
        
        for (int i = 3; i < values.length; i++) {
            if (values[i] == twoCard) {
                twoCounter++;
            }
        }
        
        if (oneCounter == 3 && twoCounter == 2) {
            result = true;
        }
        
        return result;
    }
    
    public boolean isFourOfAKind() { // Same code as isThreeOfAKind(), except the counter must equal 4.
        boolean result = false;
        int counter = 0; // Number of alike cards.
       
        for (int i = 0; i < values.length - 3; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
                result = true;
            }
        }
        
        return result;
    }
    
    public boolean isStraightFlush() {
        boolean result = false;
        
        if (isStraight() && isFlush()) {
            result = true;
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
