import java.util.*;

/**
 * A hand of Cards for a Player.
 * 
 * @author (Ethan Turkeltaub & Brett Morris)
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
    
    /**
     * Get the ArrayList of Cards in the Hand.
     * 
     * @return   An ArrayList of Cards.
     */
    public ArrayList<Card> cards() {
        return hand;
    }
    
    /**
     * Get the numerical ranking of the hand.
     * 
     * @return   The ranking of a Hand. The higher the integer, the higher the hand. The high card is the decimal places.
     */
    public double getRanking() {
        double ranking = 0;
        
        if (isStraightFlush() > 8.0) {
            ranking = isStraightFlush();
        } else if (isFourOfAKind() > 7.0) {
            ranking = isFourOfAKind();
        } else if (isFullHouse() > 6.0) {
            ranking = isFullHouse();
        } else if (isFlush() > 5.0) {
            ranking = isFlush();
        } else if (isStraight() > 4.0) {
            ranking = isStraight();
        } else if (isThreeOfAKind() > 3.0) {
            ranking = isThreeOfAKind();
        } else if (isTwoPair() > 2.0) {
            ranking = isTwoPair();
        }   else if (isPair() > 1.0) {
            ranking = isPair();
        } else {
            // WTF?
        }
        
        return ranking;
    }
    
    
    /**
     * Generate an array of values.
     * 
     * @return   An array of integers.
     */
    private int[] values() {
        int[] result = new int[5];
        
        for (int i = 0; i < hand.size(); i++) {
            result[i] = hand.get(i).intValue();
        }
        
        return result;
    }
    
    /**
     * Generate a array of suits.
     * 
     * @return   An array of suits.
     */
    private String[] suits() {
        String[] result = new String[5];
        
        for (int i = 0; i < hand.size(); i++) {
            result[i] = hand.get(i).suit();
        }
        
        return result;
    }
    
    /**
     * Check if it is a pair.
     * 
     * @return   If it is a pair, the double 1.0 plus decimals representing the high card. If not, 0.
     */
    public double isPair() {
        double result = 0.0;
        
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                result = 1.0 + (values[i] * 0.01);
            }
        }
        
        return result;
    }
    
    /**
     * Check if it is two pair.
     * 
     * @return   If it is two pair, the double 2.0 plus decimals representing the high card. If not, 0.
     */
    public double isTwoPair() {
        double result = 0.0;
        double value = 0.0;
        int counter = 0; // Number of pairs.
        
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                counter++;
                
                value = values[i] * 0.01;
            }
        }
        
        if (counter == 2) {
            result = 2.0 + value;
        }
        
        return result;
    }
    
    /**
     * Check if it is a three-of-a-kind.
     * 
     * @return   If it is three-of-a-kind, the double 3.0 plus decimals representing the high card. If not, 0.
     */
    public double isThreeOfAKind() {
        double result = 0.0;
        int counter = 0;
       
        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
                result = 3.0 + (values[i] * 0.01);
            }
        }
        
        return result;
    }
    
    /**
     * Check if it is a straight
     * 
     * @return   If it is straight, the double 4.0 plus decimals representing the high card. If not, 0.
     */
    public double isStraight() {
        double result = 0.0;
        
        for (int i = 0; i < values.length - 1; i++){
            if (values[i] == values[i + 1] - 1) {
                result = 4.0 + (values[i + 1] * 0.01);
            } else {
                result = 0.0;
            }
        }
        
        return result;
    }
    
    /**
     * Check if it is a straight.
     * 
     * @return   If it is straight, the double 5.0 plus decimals representing the high card. If not, 0.
     */
    public double isFlush() {
        double result = 0.0;
        
        String suit = suits[0];
        
        for (int i = 0; i < suits.length; i++) {
            result = 5.0 + (values[i] * 0.01);

            if (suits[i].equals(suit) == false) {
                result = 0.0;
            }
        }
        
        return result;
    }
    
    /**
     * Check if it is a full house.
     * 
     * @return   If it is full house, the double 3.0 plus decimals representing the high card. If not, 0.
     */
    public double isFullHouse() {
        double result = 0.0;
        boolean one = false;
        boolean two = false;
        
        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
                one = true;
            }
        }
        
        if (values[3] == values[4]) {
            two = true;
        }
        
        if (one && two) {
            result = 6.0 + (values[values.length - 1] * 0.01);
        }
        
        return result;
    }
    
    /**
     * Check if it is a four-of-a-kind.
     * 
     * @return   If it is four-of-a-kind, the double 7.0 plus decimals representing the high card. If not, 0.
     */
    public double isFourOfAKind() {
        double result = 0.0;
        int counter = 0;
       
        for (int i = 0; i < values.length - 3; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
                result = 7.0 + (values[i] * 0.01);
            }
        }
        
        return result;
    }
    
    /**
     * Check if it is a straight flush.
     * 
     * @return   If it is a straight flush, the double 8.0 plus decimals representing the high card. If not, 0.
     */
    public double isStraightFlush() {
        double result = 0.0;
        
        if (isStraight() > 4.0 && isFlush() > 5.0) {
            result = 8.0 + isStraight() - 4.0;
        }
        
        return result;
    }


    /**
     * Get the value of the card (2-10, J, Q, K, A).
     * 
     * @param    other   The Hand to compare to.
     * @return           An integer. If 0, then they are equal, -1 if the current hard (the one calling the method) is weaker than the other, and 1 if the hand calling the method is better.
     */
    public int compareTo(Hand other) {
        int result = 0;
        
        int thisIntRank = (int)this.getRanking();
        int otherIntRank = (int)other.getRanking();
        
        double tempThisHighCard = this.getRanking() - thisIntRank;
        double tempOtherHighCard = other.getRanking() - otherIntRank;
        
        int thisHighCard = (int)tempThisHighCard;
        int otherHighCard = (int)tempOtherHighCard;
        
        if (thisIntRank == otherIntRank){ // If the same rank.
            if (thisHighCard > otherHighCard) {
                result = 1;
            } else if (otherHighCard > thisHighCard) {
                result = -1;
            } else {
                result = 0;
            }
        } else if (thisIntRank > otherIntRank) { // If this is of greater rank.
            result = 1;
        } else if (otherIntRank > thisIntRank) { // If the other is of greater rank.
            result = -1;
        } else { // Something different?
            result = 0;
        }
        
        return result;
    }
    
    /**
     * Get a string representation of a Hand.
     * 
     * @return   The string representation of a Hand.
     */
    public String toString(){
        String result = "";
        result += hand.get(0).toString();
        
        for (int i = 1; i < 5; i++) {
            result += ", "+ hand.get(i).toString();
        }
        
        return result;
    }
}
