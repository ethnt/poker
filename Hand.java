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
        } else if (other.getRanking() > this.getRanking()) {
            result = -1;
        }
        
        return result;
    }
    
    public int getRanking() {
        int ranking = 0;
        
        if (isPair()) { ranking = 1; }
        else if (isTwoPair()) { ranking = 2; }
        else if (isThreeOfAKind()) { ranking = 3; }
        else if (isStraight()) { ranking = 4; }
        else if (isFlush()) { ranking = 5; }
        else if (isFullHouse()) { ranking = 6; }
        else if (isFourOfAKind()) { ranking = 7; }
        else if (isStraightFlush()) { ranking = 8; }
        else { /* WTF */ }
        
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
    
    private boolean isPair() {
        boolean result = false;
        
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) { // Compare the current value at i to every other card.
                if (i != j) { // Stop if from comparing itself.
                    if (values[i] == values[j]) {
                        result = true;
                    }
                }
            }
        }
        
        return result;
    }
    
    public boolean isTwoPair() {
        boolean result = false;
        int counter = 0;
        
        ArrayList<Integer> ints = new ArrayList<Integer>();
        for (int i = 0; i < values.length; i++) {
            ints.add(values[i]);
        }
        
        /*for (int i = ints.size(); i >= 0; i--) {
            for (int j = ints.size(); i >= 0; i--) {
                if (ints.get(i).intValue() == ints.get(j).intValue()) {
                    counter++;
                    ints.remove(i);
                    ints.remove(j);
                }
            }
        }*/
        
        Iterator<Integer> i = ints.iterator();
        Iterator<Integer> j = ints.iterator();
        while (i.hasNext()) {
            while (j.hasNext()) {
                if (i.next().intValue() == j.next().intValue()) {
                    counter++;
                    i.next().remove();
                    j.next().remove();
                }
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
        
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) { // Compare the current value at i to every other card.
                if (i != j) {
                    if (values[i] == values[j]) {
                        counter++;
                    }
                }
            }
        }
        
        if (counter == 6) { // 6 because every time the first for loop iterates, it counts the others that are the same, but it does this three times (one for each).
            result = true;
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
        
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) { // Compare the current value at i to every other card.
                if (i != j) {
                    if (values[i] == values[j]) {
                        counter++;
                    }
                }
            }
        }
        
        if (counter == 12) {
            result = true;
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
}
